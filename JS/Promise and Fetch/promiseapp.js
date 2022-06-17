// function getData(data) {
//   return new Promise(function (resolve, reject) {
//     setTimeout(function () {
//       if (typeof data === "string") {
//         resolve("Olumlu");
//       } else {
//         reject(new Error("string değil"));
//       }
//     }, 3000);
//   });
// }

// getData("Merhaba")
//   .then((response) => {
//     console.log(response);
//   })
//   .catch((err) => {
//     console.error(err);
//   });

function addTwo(number) {
  return new Promise((resolve, reject) => {
    setTimeout(function () {
      if (typeof number === "number") {
        resolve(number + 2);
      } else {
        reject(new Error("error"));
      }
    }, 3000);
  });
}

addTwo(10)
  .then((response) => {
    console.log(response);
    return response + 2;
  })
  .then((response2) => {
    console.log(response2);
  })
  .catch((err) => {
    console.log(err);
  });
