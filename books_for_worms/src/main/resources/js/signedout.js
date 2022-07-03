function call_signout(path, forms1, method='get') {
    fetch(path, {method:method}).
    then(response => {
        if(response.status !== 200){
            throw new Error(response.status);
        } else {
            console.log("loggedin test 1");
            document.cookie = "user_id" + "=";
            window.location.href="/";
        }
    }).
    catch((error) => {
        console.error('Error:', error);
    });
}

function initevents(){
    const form = document.getElementById("signout");
    form.addEventListener('submit', (event) => {
        // handle the form data
        event.preventDefault();
        call_signout("/signout", form, "get");
    });

}

window.addEventListener('load', (event) => {
    console.log("page is fully loaded in signedoutjs");
    initevents();
});
