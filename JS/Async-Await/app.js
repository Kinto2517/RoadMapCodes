// async function test(data) {
//   //   return data;

//   let promise = new Promise((resolve, reject) => {
//     setTimeout(() => {
//       resolve("Değer");
//     }, 3000);
//   });

//   let response = await promise;

//   console.log(response);
//   console.log("naber");
// }

// async function getCurrency(url) {
//   const response = await fetch(url);

//   const data = await response.json();

//   console.log(data);
// }

class Request {
  async get(url) {
    const response = await fetch(url);
    const data = await response.json();

    return data;
  }

  async post(url, data) {
    const response = await fetch(url, {
      method: "POST",
      body: JSON.stringify(data),
      header: {
        "Content-type": "application/json; charset=UTF-8",
      },
    });
    
    const data = await response.json();

    return data;

}


async put(url,data){
    const response = await fetch(url, {
        method: "PUT",
        body: JSON.stringify(data),
        header: {
          "Content-type": "application/json; charset=UTF-8",
        },
      });
      
      const data = await response.json();
  
      return data;
  

}
async delete(url){
    const response = await fetch(url, {
        method: "DELETE"
      });
      
      const data = await response.json();
  
      return "Başarılı Sİlindi";
  


}

// getCurrency("jsonexchangeurl");
// test("Hey");
// test("mer").then((response) => console.log(response));
