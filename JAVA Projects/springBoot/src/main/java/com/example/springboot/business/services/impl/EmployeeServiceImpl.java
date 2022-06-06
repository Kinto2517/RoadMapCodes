package com.example.springboot.business.services.impl;

import com.example.springboot.business.services.EmployeeServices;
import com.example.springboot.data.entity.EmployeeEntity;
import com.example.springboot.data.repository.EmployeeRepository;
import com.example.springboot.dto.EmployeeDto;
import com.example.springboot.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    //8080/api/v1/employees
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> entities = employeeRepository.findAll();
        for (EmployeeEntity temp:entities){
            EmployeeDto employeeDto= entityToDto(temp);
            listDto.add(employeeDto);
        }
        return listDto;
        }

    @Override
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity=dtoToEntity(employeeDto);
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }

    //8080/api/v1/employees/1
    @Override
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) throws Throwable {
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist wtih id "+ id));
        EmployeeDto employeeDto = entityToDto(employee);
        return ResponseEntity.ok(employeeDto);
    }


    @Override
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) throws Throwable {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDto);
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist wtih id "+ id));
        employee.setName(employeeEntity.getName());
        employee.setName(employeeEntity.getEmailId());

        EmployeeEntity updatedEmployee=(EmployeeEntity) employeeRepository.save(employee);
        EmployeeDto employeeDto1= entityToDto(updatedEmployee);
        return ResponseEntity.ok(employeeDto1);
    }

    @Override
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("hey"+id));
        employeeRepository.delete(employee);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }




    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto=modelMapper.map(employeeEntity,EmployeeDto.class);
        return employeeDto;

    }

    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity=modelMapper.map(employeeDto,EmployeeEntity.class);
        return employeeEntity;
    }
}
