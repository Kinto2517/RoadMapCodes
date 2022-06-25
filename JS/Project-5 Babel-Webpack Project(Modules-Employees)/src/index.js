import { Request } from "./request";
import { UI } from "./ui";
const form = document.getElementById("employee-form");
const nameInput = document.getElementById("name");
const departmentInput = document.getElementById("department");
const salaryInput = document.getElementById("salary");
const employeesList = document.getElementById("employees");
const updateEmployee = document.getElementById("update");

const request = new Request("http://localhost:3000/employees");

// request.get().then((employees) => {});

// request
//   .post({ name: "Kinto", department: "Pazarlama", salary: 500 })
//   .then((employee) => console.log(employee))
//   .catch((err) => console.err(err));

// request .put(1, { name: "Kinto", department: "Pazarlama", salary: 500 });

const ui = new UI();

eventListeners();

function eventListeners() {
  document.addEventListener("DOMContentLoaded", getAllEmployees);
    form.addEventListener("submit", addEmployee);
    employeesList.addEventListener("click", deleteEmployee);

    updateEmployee.addEventListener("click", updateEmployeeButton);

}

function updateEmployeeButton(e){
    const name = nameInput.value.trim();
    const department = departmentInput.value.trim();
    const salary = salaryInput.value.trim();
    const id = updateEmployee.dataset.id;
    request
        .put(id, { name, department, salary })
        .then((employee) => {
            ui.updateEmployeeToUI(employee);
        })
        .catch((err) => console.log(err));
}

function deleteEmployee(e) {
  if (e.target.classList.contains("delete")) {
    const id = e.target.dataset.id;
    request
      .delete(id)
      .then(() => {
        ui.deleteEmployeeFromUI(id);
      })
      .catch((err) => console.log(err));
  }
}


function addEmployee(e) {

    const name = nameInput.value.trim();
    const department = departmentInput.value.trim();
    const salary = salaryInput.value.trim();
    
    if (name === "" || department === "" || salary === "") {
        alert("Lutfen bilgileri doldurun");
        return;
    }
    else {
        request
            .post({ name, department, salary })
            .then((employee) => {
            ui.addAllEmployeesToUI([employee]);
            ui.addEmployeeToUI(employee);
            

            ui.clearInputs();
            })
            .catch((err) => console.log(err));
    }

    
    e.preventDefault();
}

function getAllEmployees() {
  request
    .get()
    .then((employees) => {
      ui.addAllEmployeesToUI(employees);
    })
    .catch((err) => console.log(err));
}
