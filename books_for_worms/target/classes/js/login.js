
function post(path, forms1, method='post') {
    fetch(path, {method:method, body: new FormData(forms1)}).
    then(response => {
        if(response.status !== 200){
            throw new Error(response.status);
        } else {
            return response.text();
        }
    }).
    then(data => {
        userid = data;
        console.log(""+userid);

        resetMessage(document.getElementById("login"));

        const cookieValue = document.cookie.split('; ').find(row => row.startsWith('user_id='))?.split('=')[1];
        document.cookie = "user_id = " + userid;
        window.location.href="/";

    }).
    catch((error) => {
        console.error('Error:', error);
        form = document.getElementById("login");
        showError(form,"Invaild username or password.");
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

function submitHandlerJs(){
    console.log("submitHandlerJs");
    const form = document.getElementById("login");
    const username = form.elements["username"];
    const password = form.elements["password"];
    form.addEventListener('submit', (event) => {
        // handle the form data
        event.preventDefault();

        let usernameVal = username.value;
        let passwordVal = password.value;
        console.log("username: " + usernameVal);
        console.log("password: " + passwordVal);
        post("/login/submit", form, "post");
    });
}

window.addEventListener('load', (event) => {
    console.log("page is fully loaded in loginjs");
    submitHandlerJs();
});
