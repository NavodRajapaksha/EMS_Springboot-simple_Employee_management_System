package edu.bootcamp.ems.controller;

import edu.bootcamp.ems.dto.EmployeeDto;
import edu.bootcamp.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save-obj")
    public EmployeeDto save(@RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }

    @GetMapping("all")
    public List<EmployeeDto> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("by-id/{id}")
    public EmployeeDto getById(@PathVariable Integer id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("by-id/{id}")
    public String deleteById(@PathVariable Integer id) {
        return employeeService.delete(id);
    }

    @PutMapping("update")
    public EmployeeDto update(@RequestBody EmployeeDto employeeDto) {
        return employeeService.update(employeeDto);
    }

    @PatchMapping("update-email")
    public String updateEmail(@RequestParam String oldEmail, @RequestParam String newEmail) {
        return employeeService.updateEmail(oldEmail,newEmail);
    }
}
