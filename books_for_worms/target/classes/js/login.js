const form = document.getElementById("login");
const username = form.elements['username'];
const password = form.elements['password'];
let usernameVal = username.value;
let passwordVal = password.value;


form.addEventListener('submit', (event) => {
    // handle the form data
    event.preventDefault();
    console.log("username: " + username);
    console.log("password: " + password);

});