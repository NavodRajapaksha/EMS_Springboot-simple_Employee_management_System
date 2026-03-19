package edu.bootcamp.ems.service;

import edu.bootcamp.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto empDto);

    List<EmployeeDto> getAll();
    
    EmployeeDto findById(Integer id);

    String delete(Integer id);

    EmployeeDto update(EmployeeDto employeeDto);

    String updateEmail(String oldEmail, String newEmail);
}
