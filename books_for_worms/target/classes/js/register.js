const form = document.getElementById("register");
const username = form.elements["username"];
const pwd = form.elements["password"];
const email = form.elements["email"];


form.addEventListener('submit', (event) => {

    event.preventDefault();
//getting the element value's
    let username_value = username.value;
    let password_value = password.value;
    let email_value = email.value;

    console.log("username" + username_value);
    console.log("password" + password_value);
    console.log("email" + email_value);
});
