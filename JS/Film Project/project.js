const form = document.getElementById("film-form");
const titleElement = document.getElementById("title");
const directorElement = document.getElementById("director");
const urlElement = document.getElementById("url");

//UI INIT
const ui = new UI();

//STORAGE
const storage = new Storage();

//EVENT LISTENERS
eventListeners();
function eventListeners() {
  form.addEventListener("submit", addFilm);
}

//ADD FILM

function addFilm(e) {
  const title = titleElement.value;
  const director = directorElement.value;
  const url = urlElement.value;

  if (title === "" || director === "" || url === "") {
    ui.displayMessages("Alanları Doldurun","danger");

} else {
    const newFilm = new Film(title,director,url);

    //ADD FILM TO UI
    ui.addFilmToUI(newFilm);
    storage.addFilmToStorage(newFilm); //STORAGE ADD STORAGEs
    ui.displayMessages("yupi","success");

  }


  ui.clearInputs(titleElement,directorElement,urlElement);

  e.preventDefault();
}
