// function getTextFile() {
//   fetch("example.txt")
//     .then((response) => {
//       return response.text();
//     })
//     .then((data) => console.log(data))
//     .catch((err) => console.err(err));
// }

// function getJsonFile() {
//     fetch("json.json")
//       .then((response) => {
//         return response.json();
//       })
//       .then((data) => console.log(data.rates.TRY))
//       .catch((err) => console.err(err));
//   }

//   function getExternalAPI() {
//     fetch("api.exchange.io/latest")
//       .then((response) => {
//         return response.json();
//       })
//       .then((data) => console.log(data))
//       .catch((err) => console.err(err));
//   }

// getTextFile();
// getJsonFile();

class Request {
  get(url) {
    fetch(url)
      .then((response) => {
        response.json();
      })
      .then((data) => {
        resolve(data);
      })
      .catch((err) => console.log(err));
  }

  post(url, data) {
    return new Promise((resolve, reject) => {
      fetch(url, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
      })
        .then((response) => {
          response.json();
        })
        .then((data) => resolve(data))
        .catch((err) => {
          reject(err);
        });
    });
  }

  put(url, data) {
    return new Promise((resolve, reject) => {
      fetch(url, {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
      })
        .then((response) => resolve(response.json()))
        .catch((err) => reject.log(err));
    });
  }

  delete(url) {
    return new Promise((resolve, reject) => {
      fetch("https://jsonplaceholder.typicode.com/albums/1", {
        method: "DELETE",
      })
        .then((response) => resolve("Başarılı"))
        .catch((err) => reject(err));
    });
  }
}

const request = new Request();
// request
//   .post("https://jsonplaceholder.typicode.com/albums", {
//     userId: 1,
//     title: "hey",
//   })
//   .then((newAlbum) => console.log(newAlbum))
//   .catch((err) => console.log(err));

// request
//   .put("https://jsonplaceholder.typicode.com/albums/1", {
//     userId: 10,
//     title: "Tarkan",
//   })
//   .then((data) => console.log(data))
//   .catch((err) => console.log(err));

request
  .delete("https://jsonplaceholder.typicode.com/albums/1")
  .then((message) => console.log(message))
  .catch((err) => console.log(err));
