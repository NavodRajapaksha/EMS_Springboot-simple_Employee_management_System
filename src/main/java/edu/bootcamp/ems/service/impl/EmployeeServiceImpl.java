package edu.bootcamp.ems.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bootcamp.ems.dto.EmployeeDto;
import edu.bootcamp.ems.entity.EmployeeEntity;
import edu.bootcamp.ems.exception.CustomException;
import edu.bootcamp.ems.repository.EmployeeRepository;
import edu.bootcamp.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public EmployeeDto save(EmployeeDto empDto) {
        Optional<EmployeeEntity> byEmail = employeeRepository.findByEmail(empDto.getEmail());

        if (byEmail.isPresent()) {
            throw new CustomException("Employee already exists");
        }

        EmployeeEntity employeeEntity = objectMapper.convertValue(empDto, EmployeeEntity.class);

        EmployeeEntity saved = employeeRepository.save(employeeEntity);

        empDto.setId(saved.getId());
        return empDto;
    }

    @Override
    public List<EmployeeDto> getAll() {
        Iterable<EmployeeEntity> allEmployyes = employeeRepository.findAll();

        ArrayList<EmployeeDto> EmployeeDtosList = new ArrayList<>();
        allEmployyes.forEach(employee -> {
            EmployeeDto employeeDto  = EmployeeDto.builder()
                    .id(employee.getId())
                    .name(employee.getName())
                    .email(employee.getEmail())
                    .build();

            EmployeeDtosList.add(employeeDto);
        });

        return EmployeeDtosList;
    }

    @Override
    public EmployeeDto findById(Integer id) {
        Optional <EmployeeEntity> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            log.info("employee exists with id {}", id);
        }

        EmployeeEntity employeeEntity = employee.get();
        return new EmployeeDto(
                employeeEntity.getId(),
                employeeEntity.getName(),
                employeeEntity.getEmail(),
                employeeEntity.getAge()
        );
    }

    @Override
    public String delete(Integer id) {
        String deleted = "employee not found. id = " + id;

        if (employeeRepository.existsById(id)) {
            deleted = "delete from employee where id = " + id;
            employeeRepository.deleteById(id);
        }

        return deleted;
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() -> new RuntimeException("employee not found."));

        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setEmail(employeeDto.getEmail());
        employeeEntity.setAge(employeeDto.getAge());

        employeeRepository.save(employeeEntity);

        return employeeDto;

    }

    @Override
    public String updateEmail(String oldEmail, String newEmail) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmail(oldEmail)
                .orElseThrow(() -> new RuntimeException("employee not found."));

        employeeEntity.setEmail(newEmail);
        employeeRepository.save(employeeEntity);

        return "employee email updated";
    }
}
