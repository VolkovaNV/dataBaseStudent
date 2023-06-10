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
    name_speciality: 'fuck'
};

let options = {
    method: 'POST',
    body: JSON.stringify(),
    headers: {
        'Content-Type': 'application/json'
    }
};


async function postData(varUrl) {
    try {
        const response = await fetch(varUrl, options)
        const res = await response.json()
        console.log('Response: ', res);
    } catch (e) {
        console.log('ErrrroR:', e);
    } finally {}
}

const formSubmit = document.querySelectorAll('.input-data-form');
const addStudent = document.querySelector('.input-container_1'),
    addSpeciality = document.querySelector('.input-container_2');
/////////////ТРЕБУЕТСЯ ОЧИСТКА ПОЛЕЙ
formSubmit.forEach(form => {
    form.addEventListener('submit', (event) => {
        event.preventDefault();
        if (addStudent.classList.contains('input-data-visible')) {
            let dataStudent = document.querySelectorAll('.reg-student');
            setStudent(dataStudent);

            options.body = JSON.stringify(student);

            newUrl = url + '/addStudent';

            postData(newUrl)
            console.log(newUrl);

        } else if (addSpeciality.classList.contains('input-data-visible')) {
            console.log("addSpecility");

            let nameSpeciality = document.querySelector('.add-speciality').value;
            console.log("Before:", speciality);

            speciality.name_speciality = nameSpeciality;
            console.log("after: ", speciality.name_speciality);

            options.body = JSON.stringify(speciality.name_speciality);


            newUrl = url + '/addSpeciality'
            postData(newUrl)
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
// const students = {
//     firstName: '',
//     secondName: '',
//     id_speciality: 0,


// }