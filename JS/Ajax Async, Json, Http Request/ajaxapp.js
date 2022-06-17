// document.getElementById("btn").addEventListener("click",function(e){

//     //XMLHttpReq

//     const xhr = new XMLHttpRequest();

//     xhr.onload = function(){//readstate 4 olursa

//         if(this.status === 200){
//             console.log(this.responseText);
//         }
//     }

//     // xhr.onreadystatechange = function(){

//     //     console.log(this.readyState);

//     //     if(this.status ==200 && this.readyState==4){
//     //         //response hazır

//     //         console.log(this.responseText);
//     //     }
//     // }
//     xhr.open("GET","example.txt",true);
//     xhr.send();//get oldugundan içi boş
// })

// document.getElementById("ajax").addEventListener("click", function () {
//   const xhr = new XMLHttpRequest();

//   xhr.onload = function () {
//     let list = document.getElementById("employees");

//     if (this.status == 200) {
//       const employees = JSON.parse(this.responseText);
//       console.log(this.responseText);

//       employees.forEach(function (employee) {
//         list.innerHTML += `<tr>
//                 <td>${employee.name}</td>
//                 <td>${employee.department}</td>
//                 <td>miyav</td>
//               </tr>
//                 `;
//       });
//     }
//   };
//   xhr.open("GET", "employees.json", true);
//   xhr.send();
// });

//API KEY
// document.getElementById("change").addEventListener("click", change);

// function change() {
//   const xhr = new XMLHttpRequest();
//   xhr.open(
//     "GET",
//     " https://api.apilayer.com/fixer/latest?base=USD&symbols=EUR,GBP,TRY"
//   );
//   xhr.setRequestHeader("apikey", "5kZSE8OxkUTWdH1pqYp7KHrrqHCbdPKH");

//   xhr.onload = function () {
//     if (this.status) {
//       const rate = JSON.parse(this.response).rates.TRY;
//       const amount = document.getElementById("amount").value;
//       document.getElementById("tl").value = amount * rate;
//     }
//   };

//   xhr.send();
// }

// setTimeout 5snde sonra kapat
// value = setInterval her 5snde
// clearInterval(value);

// function process1(callback){
//     setTimeout(function(){
//         console.log("hey");
//         callback();
//     },3000)
// }

// function process2(){
//     setTimeout(function(){
//         console.log("hey2");
//     },2000)
// }

// process1(process2);

// Ajax callbacck

class Request {
  constructor() {
    this.xhr = new XMLHttpRequest();
  }

  get(url, callback) {
    this.xhr.open("GET", url);

    this.xhr.onload = () => {
      if (this.xhr.status === 200) {
        callback(null, this.xhr.responseText);
      } else {
        callback("Hata", null);
      }
    };

    this.xhr.send();
  }

  post(url, data, callback) {
    this.xhr.open("POST", url);
    this.xhr.setRequestHeader("Content-type", "application/json");

    this.xhr.onload = () => {
      if (this.xhr.status === 201) {
        callback(null, this.xhr.responseText);
      } else {
        callback("Hata ", null);
      }
    };

    this.xhr.send(JSON.stringify(data));
  }


  put(url, data, callback) {
    this.xhr.open("PUT", url);
    this.xhr.setRequestHeader("Content-type", "application/json");

    this.xhr.onload = () => {
      if (this.xhr.status === 200) {
        callback(null, this.xhr.responseText);
      } else {
        callback("Hata put", null);
      }
    };

    this.xhr.send(JSON.stringify(data));
  }

  delete(url, callback) {
    this.xhr.open("DELETE", url);

    this.xhr.onload = () => {
      if (this.xhr.status === 200) {
        callback(null, this.xhr.responseText);
      } else {
        callback("Hata", null);
      }
    };

    this.xhr.send();
  }


}
// const request = new Request();
// request.get("https://jsonplaceholder.typicode.com/albums",function(err, response){
// console.log(response);
// });

// request.post(
//   "https://jsonplaceholder.typicode.com/albums",
//   { userId: 2, title: "Thriller" },
//   function (err, response) {
//     if (err == null) {
//       console.log(response);
//     } else {
//       console.log(err);
//     }
//   }
// );

// request.put(
//     "https://jsonplaceholder.typicode.com/albums/10",
//     { userId: 143, title: "miyov" },
//     function (err, response) {
//       if (err == null) {
//         console.log(response);
//       } else {
//         console.log(err);
//       }
//     }
//   );


// const request = new Request();
// request.delete("https://jsonplaceholder.typicode.com/albums/10",function(err, response){
// console.log(response);
// });

