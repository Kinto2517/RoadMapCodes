const form = document.getElementById("film-form");
const titleElement = document.getElementById("title");
const directorElement = document.getElementById("director");
const urlElement = document.getElementById("url");
const cardbody = document.querySelectorAll(".card-body")[1];
const clear = document.getElementById("clear-films");

// //UI INIT
// const ui = new UI();

// //STORAGE
// const storage = new Storage();

//EVENT LISTENERS
eventListeners();
function eventListeners() {
  form.addEventListener("submit", addFilm);

  document.addEventListener("DOMContentLoaded", function () {
    let films = Storage.getFilmsFromStorage();
    UI.loadAllFilms(films);
  });
  cardbody.addEventListener("click", deleteFilm);
  clear.addEventListener("click", clearAllFilms);
}

function deleteFilm(e) {
  if (e.target.id === "delete-film") {
    UI.deleteFilmFromUI(e.target);
    Storage.deleteFilmFromStorage(e.target);
    UI.displayMessages("Silindi", "info");
  }
}

//ADD FILM

function addFilm(e) {
  const title = titleElement.value;
  const director = directorElement.value;
  const url = urlElement.value;

  if (title === "" || director === "" || url === "") {
    UI.displayMessages("Alanları Doldurun", "danger");
  } else {
    const newFilm = new Film(title, director, url);

    //ADD FILM TO UI
    UI.addFilmToUI(newFilm);
    Storage.addFilmToStorage(newFilm); //STORAGE ADD STORAGEs
    UI.displayMessages("yupi", "success");
  }

  UI.clearInputs(titleElement, directorElement, urlElement);

  e.preventDefault();
}

function clearAllFilms() {
  if (confirm("Emin?")) {
    UI.clearAllFilmsFromUI();
    Storage.clearAllFilmsFromStorage();
  }
}
