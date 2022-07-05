window.onload = function() {
    function loggedin_nav() {
        const cookieValue = document.cookie
            .split('; ')
            .find(row => row.startsWith('user_id='))
            ?.split('=')[1];
        const navlogin = document.getElementById("login_nav");
        const navregister = document.getElementById("register_nav");
        const navsignout = document.getElementById("signout_nav");
        const navlibraby = document.getElementById("library_nav");
        if(cookieValue == null || cookieValue == undefined || cookieValue == "") {
            console.log("cookie does not exist");
            if(navlogin !== undefined && navlogin !== null) {
                navlogin.classList.remove("hide");
            }
            if(navregister !== undefined && navregister !== null) {
                navregister.classList.remove("hide");
            }
            if(navsignout !== undefined && navsignout !== null) {
                navsignout.classList.add("hide");
            }
            if(navlibraby !== undefined && navlibraby !== null) {
                navlibraby.classList.add("hide");
            }
        } else {
            console.log("cookie " + cookieValue);
            console.log(navlogin);
            if(navlogin !== undefined && navlogin !== null) {
                navlogin.classList.add("hide");
            }
            if(navregister !== undefined && navregister !== null) {
                navregister.classList.add("hide");
            }
            if(navsignout !== undefined && navsignout !== null) {
                navsignout.classList.remove("hide");
            }
            if(navlibraby !== undefined && navlibraby !== null) {
                navlibraby.classList.remove("hide");
            }
        }
    }
    loggedin_nav();
}