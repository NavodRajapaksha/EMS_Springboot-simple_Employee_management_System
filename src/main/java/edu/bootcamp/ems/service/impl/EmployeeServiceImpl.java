package edu.bootcamp.ems.service.impl;

import edu.bootcamp.ems.dto.EmployeeDto;
import edu.bootcamp.ems.entity.EmployeeEntity;
import edu.bootcamp.ems.repository.EmployeeRepository;
import edu.bootcamp.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity save(EmployeeDto empDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(empDto.getName());
        employeeEntity.setEmail(empDto.getEmail());
        employeeEntity.setAge(empDto.getAge());

        EmployeeEntity saved = employeeRepository.save(employeeEntity);

        return saved;
    }
}
