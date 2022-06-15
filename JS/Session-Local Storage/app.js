
const add = document.querySelector("#add");
const del = document.querySelector("#delete");
const clear = document.querySelector("#clear");
//butonlar


const addkey = document.querySelector("#addkey");
const addvalue = document.querySelector("#addvalue");
const deletekey = document.querySelector("#deletekey");


add.addEventListener("click",additem);
del.addEventListener("click",deleteitem);
clear.addEventListener("click",clearitem);

function additem(e){
sessionStorage.setItem(addkey.value, addvalue.value);
}

function deleteitem(e){
sessionStorage.removeItem(deletekey.value);
}

function clearitem(e){
sessionStorage.clear();
}

console.log();

