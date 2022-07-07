import React, { useState } from "react";
import "../App.css";
import EmployeeService from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";

const AddEmployee = () => {
  const [employee, setEmployee] = useState({
    id: "",
    firstName: "",
    lastName: "",
    emailId: "",
  });

  const navigate = useNavigate();

  const handleChange = (event) => {
    const { name, value } = event.target;
    setEmployee({ ...employee, [name]: value });
  };

  const saveEmployee = (e) => {
    e.preventDefault();
    EmployeeService.saveEmployee(employee)
      .then((res) => {
        console.log(res);
        navigate("/employeeList");
    })
      .catch((err) => {
        console.log(err);
      });
  };

  const reset = () => {
    setEmployee({
        id: "",
        firstName: "",
        lastName: "",
        emailId: "",
    });
    }
    

  return (
    <div className="flex max-w-2xl shadow border-b-2 mx-auto">
      <div className="px-8 py-8">
        <div className="font-thin text-2xl tracking-wider">
          <h1>New AddEmployee</h1>
        </div>
        <div className="items-center justify-center h-14">
          <label className="block text-gray-600 text-sm font-normal">
            First Name
          </label>
          <input
            name="firstName"
            value={employee.firstName}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"
            type="text"
          ></input>
        </div>
        <div className="items-center justify-center h-14">
          <label className="block text-gray-600 text-sm font-normal">
            Last Name
          </label>
          <input
            name="lastName"
            value={employee.lastName}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"
            type="text"
          ></input>
        </div>
        <div className="items-center justify-center h-14">
          <label className="block text-gray-600 text-sm font-normal">
            Email
          </label>
          <input
            name="emailId"
            value={employee.emailId}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 py-2"
            type="email"
          ></input>
        </div>

        <div className="items-center justify-center h-14 w-full my-4 space-x-4 pt-4">
          <button
            onClick={saveEmployee}
            className="rounded font-semibold bg-green-100"
          >
            Save
          </button>
          <button onClick={reset} className="rounded font-semibold bg-red-200">Clear</button>
        </div>
      </div>
    </div>
  );
};

export default AddEmployee;
