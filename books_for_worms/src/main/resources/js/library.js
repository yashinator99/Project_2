/**
 * This is to post to the api under the path /library
 * @param {*} path
 * @param {*} user_id
 * @param {*} selector_id
 * @param {*} method
 */
function postAllBooksLibrary(path, user_id, selector_id, method='post') {
    let libraryParams = {"user_id": user_id, "selector_id":selector_id};

    fetch(path, {method:method, body: JSON.stringify(libraryParams)}).
    then(response => {
        if(response.status !== 200){
            throw new Error(response.status);
        } else {
            return response.text();
        }
    }).
    then(data => {
        $('#library_table tr:not(:first)').remove();
        let obj = JSON.parse(data);
        let table = document.getElementById("library_table");
        for(let i = 0; i < obj.length; i++) {
            let row = table.insertRow(1);
            insertRowAll(row, obj[i]);
        }
    }).
    catch((error) => {
        console.error('Error:', error);
        $('#library_table tr:not(:first)').remove();
    });
}


function postUpdate(path, user_id, book_id, selector_id, method='post') {
    let libraryParams = {"user_id": user_id, "book_id":book_id, "selector_id":selector_id};

    fetch(path, {method:method, body: JSON.stringify(libraryParams)}).
    then(response => {
        if(response.status !== 200){
            throw new Error(response.status);
        } else {
            let selector_id = document.getElementById("library_dropdown");
            const cookieValue = document.cookie.split('; ').find(row => row.startsWith('user_id='))?.split('=')[1];
            postAllBooksLibrary("/library", cookieValue, selector_id.value, "post");
        }
    }).
    catch((error) => {
        console.error('Error:', error);
        $('#library_table tr:not(:first)').remove();
    });
}


function removeFromList(event) {
    console.log("removed");
    console.log(event.target.name);
    const cookieValue = document.cookie.split('; ').find(row => row.startsWith('user_id='))?.split('=')[1];
    postUpdate("/library/delete", cookieValue, event.target.id, event.target.name, "post");
}

function changeList(event) {
    console.log("changed");
    console.log(event.target.name);
    const cookieValue = document.cookie.split('; ').find(row => row.startsWith('user_id='))?.split('=')[1];
    postUpdate("/library/update", cookieValue, event.target.id, event.target.name, "post");
}

function insertRowAll(row,obj) {
    let btn = document.createElement("button");
    let readstatus = document.getElementById("library_dropdown").value;
    btn.id = obj['book_id'];

    if(readstatus === "all" || readstatus === "completed") {
        btn.innerHTML = "Remove";
        btn.name = "remove";
        btn.addEventListener("click", removeFromList);
    } else if(readstatus === "waiting") {
        btn.innerHTML = "Start Reading";
        btn.name = "reading";
        btn.addEventListener("click", changeList);
    } else {
        btn.innerHTML = "Finished Reading";
        btn.name = "completed";
        btn.addEventListener("click", changeList);
    }


    row.insertCell(0).innerHTML = "" + obj['title'];
    row.insertCell(1).innerHTML = "" + obj['author'];
    row.insertCell(2).appendChild(btn);
}


/**
 * This is for adding the event in library.html dropdown box
 * @param {*} event
 */
function change_selection(event) {
    console.log(event.target.value);
    const cookieValue = document.cookie.split('; ').find(row => row.startsWith('user_id='))?.split('=')[1];
    postAllBooksLibrary("/library", cookieValue, event.target.value, "post");
}


function libraryHandlerJs(){
    let selector_id = document.getElementById("library_dropdown");
    selector_id.addEventListener("change", change_selection);
    const cookieValue = document.cookie.split('; ').find(row => row.startsWith('user_id='))?.split('=')[1];
    postAllBooksLibrary("/library", cookieValue, "all", "post");

}

window.addEventListener('load', (event) => {
    console.log("page is fully loaded in libraryjs");
    libraryHandlerJs();
});