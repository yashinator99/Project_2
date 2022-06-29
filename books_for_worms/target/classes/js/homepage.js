const form = document.getElementById('bookSearch');
const searchBy = form.elements['select']
const searchTerm = form.elements['search'];
form.addEventListener('submit', (event =>{
    event.preventDefault();
    console.log(searchTerm.value);
    console.log(searchBy.value);
}));