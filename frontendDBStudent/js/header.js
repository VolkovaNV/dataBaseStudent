const ulItem = document.querySelectorAll('.ul__item');
const inputContainer = document.querySelectorAll('.input-data');

ulItem.forEach((element, iter) => {
    element.addEventListener('click', () => {
        for (let i = 0; i < ulItem.length; i++)
            ulItem[i].classList.remove('ul-active');
        inputContainer.forEach(el => {
            el.classList.remove('input-data-visible');

        })
        if (iter == ulItem.length - 1) {
            options.method = 'GET';
            newUrl = url + '/getTable';
            postData(newUrl).then((res) => {
                setDataTable(res);
            });
        }
        inputContainer[iter].classList.add('input-data-visible');
        element.classList.add('ul-active');
        //Получение данных при нажатии на последний элемент(!!"Список студентов")
    })
});