
console.log("test");
const form = document.getElementById("login");
const username = form.elements["username"];
const password = form.elements["password"];
console.log("test1");


form.addEventListener('submit', (event) => {
    // handle the form data
    event.preventDefault();
    let usernameVal = username.value;
    let passwordVal = password.value;
    console.log("username: " + usernameVal);
    console.log("password: " + passwordVal);
    //window.location.href="login/submit";
});

