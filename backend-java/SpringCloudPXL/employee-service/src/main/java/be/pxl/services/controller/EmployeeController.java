package be.pxl.services.controller;

import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity getEmployees() {
        return new ResponseEntity(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Long id) {
        return new ResponseEntity(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addEmployee(@RequestBody EmployeeRequest employee) {
        return new ResponseEntity(employeeService.addEmployee(employee),HttpStatus.CREATED);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity getEmployeesByOrganization(@PathVariable Long organizationId) {
        return new ResponseEntity(employeeService.getEmployeesByOrganization(organizationId),HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity getEmployeesByDepartment(@PathVariable Long departmentId) {
        return new ResponseEntity(employeeService.getEmployeesByDepartment(departmentId),HttpStatus.OK);
    }
}
