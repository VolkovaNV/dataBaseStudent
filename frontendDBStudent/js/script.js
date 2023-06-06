const btnSubmit = document.querySelector('.input-data-form');
const url = 'http://127.0.0.1:5501';



let options = {
    method: 'POST',
    //body: JSON.stringify(data),
    headers: {
        'Content-Type': 'application/json'
    }
};


async function postData(url) {

    try {
        const response = await fetch(url, options)
        const data = await response.json()
        console.log('Data: ', JSON.stringify(data));
        btnSubmit.classList.remove('submit-btn');
    } catch (e) {
        console.log('Fuck:', e);

    }

    // const response = await fetch(url, {
    //     body: JSON.stringify(data) // body data type must match "Content-Type" header
    // });
    // return await response.json(); // parses JSON response into native JavaScript objects
}



dataInputs = document.querySelectorAll('.control__input');
postData(url)
btnSubmit.addEventListener('submit', () => {
    //console.log(dataInputs);
    //postData('localhost:5500', dataInputs)
    postData(url)
});

// const students = {
//     firstName: '',
//     secondName: '',
//     id_speciality: 0,


// }