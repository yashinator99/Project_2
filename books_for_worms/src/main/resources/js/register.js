function post(path, forms1, method='post'){
    fetch(path, {method:method, body: new FormData(forms1)}).
    then(response => {
        if(response.status !== 200){
            throw new Error(response.status);
        }else{
            window.location.href="/login";
        }
    }).
    catch((error) => {
        console.error('Error:', error);
    });
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
        let password_value = pwd.value;
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