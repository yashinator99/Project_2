
console.log("test");
const form = document.getElementById("login");
const username = form.elements["username"];
const password = form.elements["password"];
console.log("test1");

function post(path, forms1, method='post') {

    // The rest of this code assumes you are not using a library.
    // It can be made less verbose if you use one.
    forms1.method = method;
    forms1.action = path;
    forms1.submit();
}

form.addEventListener('submit', (event) => {
    // handle the form data
    event.preventDefault();
    let usernameVal = username.value;
    let passwordVal = password.value;
    console.log("username: " + usernameVal);
    console.log("password: " + passwordVal);
    let userid = post("/login/submit", form, "post");
    console.log(userid);
    //window.location.href="login/submit";
});

