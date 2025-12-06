package edu.bootcamp.ems.service;

import edu.bootcamp.ems.dto.EmployeeDto;
import edu.bootcamp.ems.entity.EmployeeEntity;

public interface EmployeeService {

    EmployeeEntity save(EmployeeDto empDto);
}
