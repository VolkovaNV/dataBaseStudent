const url = 'http://localhost:8000';


let data = {
    firstName: '',
    secondName: '',
    id_speciality: 0,
    course: 0,
    numGroup: 0
};

let options = {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
        'Content-Type': 'application/json'
    }
};


async function postData(varUrl) {

    try {
        const response = await fetch(varUrl, options)
        const res = await response.json()
        console.log('Response: ', res);
        //btnSubmit.classList.remove('submit-btn');
    } catch (e) {
        console.log('ErrrroR:', e);

    }
}

const formSubmit = document.querySelector('.input-data-form');
formSubmit.addEventListener('submit', () => {
    postData(url)
    let dataInputs = document.querySelectorAll('.reg-student');
    setStudent(dataInputs);

    options.body = JSON.stringify(data);
    console.log(options);

    newUrl = url + '/data';
    postData(newUrl)
    console.log(newUrl);

});

function setStudent(inputValue) {
    data.firstName = inputValue[0].value;
    data.secondName = inputValue[1].value;
    data.id_speciality = inputValue[2].value;
    data.course = inputValue[3].value;
    data.numGroup = inputValue[4].value;
}
// const students = {
//     firstName: '',
//     secondName: '',
//     id_speciality: 0,


// }