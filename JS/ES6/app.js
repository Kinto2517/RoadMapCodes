const hey = document.getElementById("hey");

hey.textContent = "heyybitchhh";

const merhabaa = function () {};

const merhaba = () => {};

const cube = (x) => x * x * x;

let number1,number2;

arr = [100,200,300];

// number1 = arr[0];
// number2 = arr[1];
// Destructing

[number1,number2]=arr;

//obj destructing
const numbers = {
    a:10,
    b:20,
    c:30
};
const {a:num1,c,e} = numbers; 

//func destructing
const getLangs  = () => ["Python", "Java"];
[la1,la2]=getLangs();


//obj
const person = {
    name:"hey",
    year:25,
    showInfos : ()=> console.log("bilgier")
}
const {name:isim, year:yil, showInfos:bilgiler} = person;


//spread


const langs = ["py","hey"];

console.log(...langs);

const langs2 = [...langs,"psy","hgdsey"];

const numbers1 = [1,2,3,4,5,6];

const [a,b,...numbers2] = numbers1;

const addNumbers = (a,b,c) => console.log(a+b+c);

addNumbers(...numbers1);










