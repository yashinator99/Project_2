function post(path, forms1, method='post'){
    fetch(path, {method:method, body: new FormData(forms1)}).
    then(response => {
        if(response.status !== 200){
            throw new Error(response.status);
        }else{
            return response.text();
        }
    }).
    then(data => {
        data = (ctx.formParam("username"), ctx.formParam("password"), ctx.formParam("email"));
        console.log(""+ data);

        resetMessage(document.getElementById("register"));
        window.location.href="register";

    }).
    catch((error) => {
        console.error('Error:', error);
        form = document.getElementById("register");
        showError(form,"Invalid input.");
        });
}

function resetMessage(input) {
    // get the small element and set the message
    const msg = input.parentNode.querySelector("small");
    msg.innerText = "";
    // update the class for the input
    msg.style.color = "black";
}

function showMessage(input, message, type) {
    // get the small element and set the message
    const msg = input.parentNode.querySelector("small");
    msg.innerText = message;
    // update the class for the input
    msg.style.color = "red";
}

function showError(input, message) {
    return showMessage(input, message, false);
}



function registerHandlerJs() {
    const form = document.getElementById("register");
    const username = form.elements["username"];
    const pwd = form.elements["password"];
    const email = form.elements["email"];
    form.addEventListener('submit', (event) => {
        //handling form data
        event.preventDefault();
    //getting the element value's
        let username_value = username.value;
        let password_value = password.value;
        let email_value = email.value;
        post("/register/submit", form, "post");

        console.log("username" + username_value);
        console.log("password" + password_value);
        console.log("email" + email_value);
    });
}

window.addEventListener('load', (event) => {
    console.log("page is fully loaded in registerjs");
    registerHandlerJs();
});