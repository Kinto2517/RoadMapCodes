class Storage{

    static addFilmToStorage  (newFilm) {
        let films = this.getFilmsFromStorage();
      
        films.push(newFilm);
        localStorage.setItem("films", JSON.stringify(films));
      
        /*
          [
              {title:"", director:"",url:""}
          ]
          */
      };
      
      static getFilmsFromStorage () {
        let films;
        if (localStorage.getItem("films") === null) {
          films = [];
        } else {
          films = JSON.parse(localStorage.getItem("films"));
        }
      
        return films;
      };
      
      static deleteFilmFromStorage  (element) {
        let films = this.getFilmsFromStorage();
        const name =
          element.parentElement.previousElementSibling.previousElementSibling
            .textContent;
      
        films.forEach(function (film, index) {
          if (film.title === name) {
            films.splice(index, 1);
          }
        });
      
        localStorage.setItem("films", JSON.stringify(films));
      };
      
      static clearAllFilmsFromStorage () {
      
          localStorage.removeItem("films");
      };
      


}
