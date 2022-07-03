function searchpost(path, forms1, method='post'){
    fetch(path, {method:method, body: new FormData(forms1)}).
    then(response => {
        if(response.status !== 200){
            throw new Error(response.status);
        } else {
            return response.text();
        }
    }).
    then(data => {
        $('#search_table tr:not(:first)').remove();
        console.log(data);
        let obj = JSON.parse(data);
        console.log(obj);
        document.getElementById("homepage_disp").classList.remove("hide");
        let table = document.getElementById("search_table");
        for(let i = 0; i < obj.length; i++) {
            console.log("i: " + i);
            let row = table.insertRow(1);
            console.log(obj[i]);
            insertRow(row, obj[i]);
        }
    }).
    catch((error) => {
        console.error('Error:', error);

    });
}
function addToList(){
    console.log("clicked added to list");
}

function insertRow(row,obj) {
    const dateObject = new Date((obj['year']));
    let btn = document.createElement("button");
    btn.innerHTML = "Add";
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


function searchsubmit(){
    const form = document.getElementById("bookSearch");
    document.getElementById("homepage_disp").classList.add("hide");

    form.addEventListener('submit', (event =>{
        event.preventDefault();
        console.log(form.elements['select'].value); //The dropdown box
        console.log(form.elements['search'].value); //The search box
        searchpost("/homepage/search", form);
    }));
}
window.addEventListener('load', (event) => {
    console.log("page is fully loaded in homepagejs");
    searchsubmit();
});
