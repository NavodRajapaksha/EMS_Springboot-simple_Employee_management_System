package edu.bootcamp.ems.controller;

import edu.bootcamp.ems.dto.EmployeeDto;
import edu.bootcamp.ems.entity.EmployeeEntity;
import edu.bootcamp.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save-obj")
    public EmployeeEntity save(@RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }
}
