package backendDBStudent.src.main.java.org.example;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;




import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class WebServer {
    public void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/data", new DataHandler());
        server.createContext("/", new StaticFileHandler("../frontendDBStudent"));
        server.setExecutor(null);
        server.start();
        System.out.println("Server is running on port 8000");
    }

    static class DataHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
                String requestBody = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
                System.out.println("Received data: " + requestBody);

                // Здесь вы можете добавить логику для обработки данных
                // и записи их в таблицу на PostgreSQL

                //String response = "Data received successfully";
                String response = "{\"message\": \"Data received successfully\"}";
                exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
                exchange.sendResponseHeaders(200, response.length());
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(response.getBytes());
                outputStream.close();
            } else if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
                exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
                exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "POST, OPTIONS");
                exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
                exchange.sendResponseHeaders(204, -1);
                exchange.close();
            } else {
                String response = "Invalid request method";
                exchange.sendResponseHeaders(400, response.length());
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(response.getBytes());
                outputStream.close();
            }
        }
    }


    static class StaticFileHandler implements HttpHandler {
        private String rootPath;

        public StaticFileHandler(String rootPath) {
            this.rootPath = rootPath;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestPath = exchange.getRequestURI().getPath();
            Path filePath = Paths.get(rootPath, requestPath.substring(1));

            if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
                byte[] fileBytes = Files.readAllBytes(filePath);

                String contentType = Files.probeContentType(filePath);
                exchange.getResponseHeaders().set("Content-Type", contentType);
                exchange.sendResponseHeaders(200, fileBytes.length);

                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(fileBytes);
                outputStream.close();
            } else {
                exchange.sendResponseHeaders(404, 0);
                exchange.close();
            }
        }
    }

    static class OptionsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
            exchange.sendResponseHeaders(204, -1);
            exchange.close();
        }
    }

}


