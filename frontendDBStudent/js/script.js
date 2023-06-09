const url = 'http://localhost:8000';

// const delay = ms => {
//     return new Promise(r => setTimeout(() => r(), ms))
// }

let student = {
    firstName: '',
    secondName: '',
    id_speciality: 0,
    course: 0,
    numGroup: '',
};

let speciality = {
    name_speciality: ''
};

let subject = {
    name_subject: ''
};

let options = {
    method: 'POST',
    body: JSON.stringify(),
    headers: {
        'Content-Type': 'application/json'
    }
};


// async function postData(varUrl) {
//     try {
//         const response = await fetch(varUrl, options)
//         const res = await response.json();
//         console.log('Response: ', res);
//         resolve(res);
//     } catch (e) {
//         console.log('ErrrroR:', e);
//     } finally {}
// }

function postData(varUrl) {
    return new Promise(async(resolve, reject) => {
        try {
            const response = await fetch(varUrl, options);
            const res = await response.json();
            console.log('Response: ', res);
            resolve(res); // Возвращаем значение res через промис
        } catch (e) {
            console.log('ErrrroR:', e);
            reject(e); // Возвращаем ошибку через промис
        }
    });
}


const formSubmit = document.querySelectorAll('.input-data-form');
const addStudent = document.querySelector('.input-container_1'),
    addSpeciality = document.querySelector('.input-container_2'),
    addSubject = document.querySelector('.input-container_3'),
    getTable = document.querySelector('.input-container_4').classList.contains('input-data-visible');

formSubmit.forEach(form => {
    form.addEventListener('submit', (event) => {
        //event.preventDefault();
        if (addStudent.classList.contains('input-data-visible')) { //Отправка данных студента
            let dataStudent = document.querySelectorAll('.reg-student');
            options.method = 'POST';
            setStudent(dataStudent);

            options.body = JSON.stringify(student);

            newUrl = url + '/addStudent';
            postData(newUrl)

        } else if (addSpeciality.classList.contains('input-data-visible')) { //Отправка названия специальности
            let nameSpeciality = document.querySelector('.add-speciality').value;
            options.method = 'POST';

            speciality.name_speciality = nameSpeciality;

            options.body = JSON.stringify(speciality.name_speciality);

            newUrl = url + '/addSpeciality'
            postData(newUrl)

        } else if (addSubject.classList.contains('input-data-visible')) { //Отправка названия предмета
            let nameSubject = document.querySelector('.add-subject').value;
            options.method = 'POST';

            subject.name_subject = nameSubject;
            options.body = JSON.stringify(subject.name_subject);
            newUrl = url + '/addSubject';

            postData(newUrl);
        } else if (getTable) {
            options.method = 'GET';

            newUrl = url + '/getTable';
            postData(newUrl).then((res) => {
                setDataTable(res);
            });
            //console.log("this is response: ", res);


        }
    });
})


function setStudent(inputValue) {
    student.firstName = inputValue[0].value;
    student.secondName = inputValue[1].value;
    student.id_speciality = inputValue[2].value;
    student.course = inputValue[3].value;
    student.numGroup = inputValue[4].value;
}

function setDataTable(res = null) {
    //let tableBody = document.querySelector('.table__body').innerHTML;

    let tableBody = ``;
    res.forEach(e => {
        tableBody += `<tr>
        <td>${e.first_name}</td>
        <td>${e.second_name}</td>
        <td>${e.course}</td>
        <td>${e.name_speciality}</td>
        <td>${e.num_group}</td>
        </tr>`
    })
    document.querySelector('.table__body').innerHTML = tableBody;

}
// const students = {
//     firstName: '',
//     secondName: '',
//     id_speciality: 0,


// }