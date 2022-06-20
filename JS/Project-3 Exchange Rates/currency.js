class Currency {
  constructor(firstCurrency, secondCurrency) {
    this.firstCurrency = firstCurrency;
    this.secondCurrency = secondCurrency;
    this.url = "https://api.apilayer.com/fixer/latest?base=";
    this.amount = null;
  }

  exchange() {
    const xhr = new XMLHttpRequest();
    xhr.open(
      "GET",
      " https://api.apilayer.com/fixer/latest?base=" +
        this.firstCurrency +
        "&symbols=" +
        this.secondCurrency
    );
    xhr.setRequestHeader("apikey", "5kZSE8OxkUTWdH1pqYp7KHrrqHCbdPKH");

    xhr.onload = function () {
      if (this.status) {
        const rate = JSON.parse(this.responseText);
        const amount = document.getElementById("amount").value;
        const curr = rate["rates"][secondCurrency.value];
        const total = curr * amount;
        ui.displayResult(55);
      }
    };

    xhr.send();

    // fetch(this.url + this.firstCurrency)
    //   .then((response) => response.json())
    //   .then((data) => console.log(data))
    //   .catch((err) => console.log(err));
  }

  changeAmount(amount) {
    this.amount = amount;
  }

  changeFirstCurrency(newFirstCurrency) {
    this.firstCurrency = newFirstCurrency;
  }

  changeSecondCurrency(newSecondCurrency) {
    this.secondCurrency = newSecondCurrency;
  }
}
