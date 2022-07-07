import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";

const EmployeeList = () => {
  const [loading, setLoading] = useState(true);
  const [employees, setEmployees] = useState(null);

  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await EmployeeService.getEmployees();
        setEmployees(response.data);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  const deleteEmployee = (e, id) => {
    e.preventDefault();
    EmployeeService.deleteEmployee(id).then((res) => {
      if (employees) {
        setEmployees((prevElement) => {
          return prevElement.filter((employee) => employee.id !== id);
        });
      }
    });
  };

  const editEmployee = (e, id) => {
    e.preventDefault();
    navigate(`/editEmployee/${id}`);
  };

  return (
    <>
      <div class="container flex mx-auto my-8">
        <div className="h-12">
          <button
            onClick={() => navigate("/addEmployee")}
            class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-6 rounded"
          >
            AddEmployee
          </button>
        </div>
        <div class="flex flex-col">
          <div class="w-full">
            <div class="border-b border-gray-200 shadow">
              <table class="divide-y divide-gray-300 ">
                <thead class="bg-gray-50">
                  <tr>
                    <th class="px-6 py-2 text-xs text-gray-500">First Name</th>
                    <th class="px-6 py-2 text-xs text-gray-500">Last Name</th>
                    <th class="px-6 py-2 text-xs text-gray-500">Email</th>
                    <th class="px-6 py-2 text-xs text-gray-500">Actions</th>
                  </tr>
                </thead>
                {!loading && (
                  <tbody class="bg-white divide-y divide-gray-300">
                    {employees.map((employee) => (
                      <tr class="whitespace-nowrap" key={employee.id}>
                        <td class="px-6 py-4 text-sm text-gray-500">
                          <div class="text-sm text-gray-900">
                            {employee.firstName}
                          </div>
                        </td>
                        <td class="px-6 py-4">
                          <div class="text-sm text-gray-900">
                            {employee.lastName}
                          </div>
                        </td>
                        <td class="px-6 py-4">
                          <div class="text-sm text-gray-900">
                            {employee.emailId}
                          </div>
                        </td>

                        <td class="px-6 py-4 whitespace-nowrap font-thin">
                          <a
                            onClick={(e, id) => editEmployee(e, employee.id)}
                            className="text-indigo-600 hover:text-indigo-800 px-4 hover:cursor-pointer"
                          >
                            Edit
                          </a>
                          <a
                            onClick={(e, id) => deleteEmployee(e, employee.id)}
                            className="px-4 text-red-400 hover:text-red-600 hover:cursor-pointer"
                          >
                            Delete
                          </a>
                        </td>
                      </tr>
                    ))}
                  </tbody>
                )}
              </table>
            </div>
          </div>
        </div>
      </div>
      ;
    </>
  );
};

export default EmployeeList;
