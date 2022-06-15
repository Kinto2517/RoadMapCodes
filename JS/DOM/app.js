/* // const elements = document.getElementsByTagName('*');

// let value;

// //for (let index = 0; index < elements.length; index++) {
//   //  console.log(elements[i]);
// //}

// value= document.scripts[2];

// value= document.links[document.links.length-1].getAttribute("class");
// value= document.links[document.links.length-1].getAttribute("href");

// //const collections = Array.from(elements);
// //collections.forEach(function(collection){
//  //   console.log(collection);
// //});

// value=document.forms;
// value=document.forms["form"];
// value=document.forms[0].id;
// value=document.forms[0].getAttribute("id");

let element;
element = document.getElementById("todo-form");
element = document.getElementsByClassName("list-group-item");

element = document.getElementsByTagName("div");

// Query selector - css selector

//id
element = document.querySelector("#todo-form");
element = document.querySelector("#tasks-title");

//class
element = document.querySelectorAll(".list-group-item");

element.forEach(function(el){
    console.log(el);
}); 

//li div
element = document.querySelector("li");

console.log(element);
 */

const element = document.querySelector("#clear-todos");

// console.log(element.id);
// console.log(element.className);
// console.log(element.classList[0]);
// console.log(element.textContent);
// console.log(element.innerHTML);
// console.log(element.href);

// //style ve element özellikleri
// element.className = "btn btn-primary";
// element.style.color="#000";
// element.style.marginLeft="20px"
// element.href="";
// element.target="_blank";

// element.innerHTML="<span style='color:green'>Silin</span>"

// const elements = document.querySelectorAll(".list-group-item");
// elements.forEach(function(el){
//     el.style.color = "red";
//     el.style.background = "#eee";
// })

// let element2 = document.querySelector("li:last-child");
// element2 = document.querySelector("li:nth-child(2)");
// element2 = document.querySelectorAll("li:nth-child(even)");

// element2.forEach(function (el){
//     el.style.background="#ccc";
//     el.style.color = "red";
// });


// let value;

// const todoList = document.querySelector(".list-group");
// const todo = document.querySelector(".list-group-item:nth-child(2)");
// const cardrow = document.querySelector(".card.row");
// value = cardrow;

// value = cardrow.children; 
// value = todo.previousElementSibling;

// value = todo.nextElementSibling;



// const newLink = document.createElement("a");
// const cardbody = document.getElementsByClassName("card-body")[1];
// newLink.id="clear-todos";
// newLink.className = "btn btn-danger";
// newLink.href="google.com"; 
// newLink.target="_blank";

// newLink.appendChild(document.createTextNode("Nbr"));

// // cardbody.removeChild(newLink);
// // cardbody.remove;
// // cardbody.replaceChild();


// console.log(newLink);



const filterInp = document.getElementById("filter");


// filterInp.onfocus = function(){
//     console.log("nbr");
//     // cardbody.appendChild(newLink);
// }

// filterInp.addEventListener("focus",function(e){
//     console.log(e);
//     e.target.placeholder="hey";
// console.log("hey");
// });

// const todoFormSubmit = document.getElementById("todo-form");

// todoFormSubmit.addEventListener("submit",submitForm);
// document.addEventListener("keydown",function(e){
//     console.log("meya");
//     console.log(e.key);
//     e.preventDefault();
// });

// function submitForm(e){
// console.log("Submit Eventi");



// e.preventDefault();
// }
document.addEventListener("dblclick",function(){

    console.log("he");
});

document.addEventListener("DOMContentLoaded",function(e){
    console.log("miyeee"); 
});

const cardbody= document.querySelectorAll(".card-body")[1];

cardbody.addEventListener("click",function(e){

    if(e.target.className === "fa fa-remove"){

    }

    if(e.target.id==="filter"){

    }
    if(e.target.id==="clear-todos"){
        
    }

});
