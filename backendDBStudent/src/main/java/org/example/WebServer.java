package backendDBStudent.src.main.java.org.example;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class WebServer {
    public void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/data", new DataHandler());
        server.createContext("/", new StaticFileHandler("frontendDBStudent"));
        server.setExecutor(null);
        server.start();

        // Запуск фронтенда
        String frontendPath = "frontendDBStudent";
        String indexFile = frontendPath + "/index.html";
        String os = System.getProperty("os.name").toLowerCase();
        String command = "";

        if (os.contains("win")) {
            command = "cmd /c start " + indexFile;
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            command = "xdg-open " + indexFile;
        }

        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server is running on port 8000");
    }

    static class DataHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Обработка запросов
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
}
