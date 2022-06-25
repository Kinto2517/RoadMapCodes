export class UI {
  constructor() {
    this.employeesList = document.getElementById("employees");
    this.updateButton = document.getElementById("update");
    this.nameInput = document.getElementById("name");
    this.salaryInput = document.getElementById("salary");
    this.departmentInput = document.getElementById("department");
  }

  addAllEmployeesToUI(employees) {
    let result = "";

    employees.forEach((employee) => {
      result += `
            
            <tr>
                <td>${employee.name}</td>
                <td>${employee.department}</td>
                <td>${employee.salary}</td>
                <td>
                    <a href="#" class="btn btn-danger btn-sm delete" data-id="${employee.id}">Delete</a>
                    <a href="#" class="btn btn-info btn-sm edit" data-id="${employee.id}">Edit</a>

                </td>
            </tr>

            `;
    });
    this.employeesList.innerHTML = result;
  }

  addEmployeeToUI(employee) {
    this.employeesList.innerHTML += `
        
        <tr>
            <td>${employee.name}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>
            <td>
                <a href="#" class="btn btn-danger btn-sm delete" data-id="${employee.id}">Delete</a>
                <a href="#" class="btn btn-info btn-sm edit" data-id="${employee.id}">Edit</a>

            </td>
        </tr>

        `;
    

  }

  updateEmployeeToUI(employee) {
    const employees = document.querySelectorAll("#employees tr");
    employees.forEach((employee) => {
      if (employee.dataset.id == employee.id) {
        employee.innerHTML = `
                <td>${employee.name}</td>
                <td>${employee.department}</td>
                <td>${employee.salary}</td>
                <td>
                    <a href="#" class="btn btn-danger btn-sm delete" data-id="${employee.id}">Delete</a>
                    <a href="#" class="btn btn-info btn-sm edit" data-id="${employee.id}">Edit</a>

                </td>
            `;
      }
    });
  }

  deleteEmployeeFromUI(id) {
    const employees = document.querySelectorAll("#employees tr");
    employees.forEach((employee) => {
      if (employee.dataset.id == id) {
        employee.remove();
      }
    });
  }



  clearInputs() {
    this.nameInput.value = "";
    this.salaryInput.value = "";
    this.departmentInput.value = "";
  }
}
