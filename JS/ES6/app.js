// const hey = document.getElementById("hey");

// hey.textContent = "heyybitchhh";

// const merhabaa = function () {};

// const merhaba = () => {};

// const cube = (x) => x * x * x;

// let number1, number2;

// arr = [100, 200, 300];

// // number1 = arr[0];
// // number2 = arr[1];
// // Destructing

// [number1, number2] = arr;

// //obj destructing
// const numbers = {
//   a: 10,
//   b: 20,
//   c: 30,
// };
// const { a: num1, c, e } = numbers;

// //func destructing
// const getLangs = () => ["Python", "Java"];
// [la1, la2] = getLangs();

// //obj
// const person = {
//   name: "hey",
//   year: 25,
//   showInfos: () => console.log("bilgier"),
// };
// const { name: isim, year: yil, showInfos: bilgiler } = person;

// //spread

// const langs = ["py", "hey"];

// console.log(...langs);

// const langs2 = [...langs, "psy", "hgdsey"];

// const numbers1 = [1, 2, 3, 4, 5, 6];

// const [a, b, ...numbers2] = numbers1;

// const addNumbers = (a, b, c) => console.log(a + b + c);

// addNumbers(...numbers1);

// for (let prop in person) {
//   console.log(prop, person[prop]);
// }

// //array ve stringlerde işler
// for (let value of numbers1) {
//   console.log(value);
// }

// let myMap = new Map();

// console.log(typeof myMap);

// const key1 = "hey";
// const key2 = { a: 10, b: 10 };

// myMap.set(key1, "string değer");
// myMap.set(key2, "object literal");

// function Person() {}
// Person.prototype.test1 = function () {
//   console.log("test1");
// };

// function Employee(name, age) {
//   this.name = name;
//   this.age = age;
// }

// const emp1 = new Employee("hey", "hey");

// Employee.prototype.showInfos = function () {
//   console.log("constr a infos func eklemek");
// };

// Employee.prototype = Object.create(Person.prototype);

// emp1.test1;

// ////CALLL METHODDD

// const obj1 = {
//   number1: 10,
//   number2: 20,
// };

// const obj2 = {
//   number3: 10,
//   number4: 20,
// };

// function addNum(num3, num4) {
//   console.log(this.number1, this.number2, num3, num4);
// }

// addNum.call(obj1, 5, 3);

// addNum.apply(obj1,[100,200]);

// function getNumbersTotal(num3,num4){
//    return this.number1, this.number2, num3, num4;
// }

// const copyFunc1 = getNumbersTotal.bind(obj1);

// function Person(name, age) {
//   this.name = name;
//   this.age = age;
// }

// function Employee(name, age, salary) {
//   Person.call(this, name, age);
//   this.salary = salary;
// }

class Person {
constructor(salary){
    this.salary = salary;
}

}


class Employee extends Person{
  constructor(name, age,salary) {
    super(salary);
    this.name = name;
    this.age = age;
  }
  showInfos() {

  }

 static cube(x){ //staticler obje açılmadan kullanlır
     return x*x*x;
 }

}


const emp = new Employee("m", 2);

emp.cube(4);


