
function recommendpost(path, method='post'){
    console.log("test2");
    fetch(path, {method:method}).
    then(response => {
        if(response.status !== 200){
            throw new Error(response.status);
        } else {
            return response.text();
        }
    }).
    then(data => {
        $('#recommend_table tr:not(:first)').remove();
        let obj = JSON.parse(data);
        let table = document.getElementById("recommend_table");
        for(let i = 0; i < obj.length; i++) {
            let row = table.insertRow(1);
            insertRow(row, obj[i]);
        }
    }).
    catch((error) => {
        console.error('Error:', error);

    });
}

function addToList(event){
    console.log("clicked added to list");
    console.log(event.target.id);
    const cookieValue = document.cookie.split('; ').find(row => row.startsWith('user_id='))?.split('=')[1];
    postBooktoLibrary("/homepage/addToList",cookieValue, event.target.id, "post");
}

function postBooktoLibrary(path, user_id, button_id, method='post') {
    let libraryParams = {"user_id": user_id, "book_id":button_id};

    fetch(path, {method:method, body: JSON.stringify(libraryParams)}).
    then(response => {
        if(response.status !== 200){
            throw new Error(response.status);
        } else {
            return response.text();
        }
    }).
    then(data => {
       console.log(data);
    }).
    catch((error) => {
        console.error('Error:', error);
    });
}

function insertRow(row,obj) {
    const dateObject = new Date((obj['year']));
    let btn = document.createElement("button");
    btn.innerHTML = "Add";
    btn.id = obj['book_id'];
    row.insertCell(0).innerHTML = "" + obj['title'];
    row.insertCell(1).innerHTML = "" + obj['author'];
    row.insertCell(2).innerHTML = "" + obj['genre'];
    row.insertCell(3).innerHTML = "" + dateObject.toLocaleString("en-US", {year: "numeric"});
    row.insertCell(4).innerHTML = "" + obj['fiction'];
    row.insertCell(5).innerHTML = "" + obj['description'];

    const cookieValue = document.cookie.split('; ').find(row => row.startsWith('user_id='))?.split('=')[1];
    if(cookieValue == null || cookieValue == undefined || cookieValue == "") {
        btn.disabled = true;
    } else{
        btn.addEventListener("click", addToList);
    }
    row.insertCell(6).appendChild(btn);
}

function getRandomBook(){
    console.log("test1");
    recommendpost("/recommendation", "post");
}

window.addEventListener('load', (event) => {
    console.log("page is fully loaded in recommendjs");
    getRandomBook();
});
