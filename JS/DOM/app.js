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

//style ve element özellikleri
element.className = "btn btn-primary";
element.style.color="#000";
element.style.marginLeft="20px"
element.href="";
element.target="_blank";

