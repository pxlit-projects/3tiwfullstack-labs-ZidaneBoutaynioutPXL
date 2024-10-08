package be.pxl.services.services;

import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.domain.dto.EmployeeResponse;
import be.pxl.services.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees =  employeeRepository.findAll();
        return employees.stream().map(this::mapEmployeeToEmployeeResponse).toList();
    }

    public EmployeeResponse getEmployeeById(Long id) {
        return employeeRepository.findById(id).map(this::mapEmployeeToEmployeeResponse).orElse(null);
    }

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = mapEmployeeRequestToEmployee(employeeRequest);
        return mapEmployeeToEmployeeResponse(employeeRepository.save(employee));
    }

    public List<Employee> getEmployeesByOrganization(Long organizationId) {
        return employeeRepository.findByOrganizationId(organizationId);
    }

    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    private EmployeeResponse mapEmployeeToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .organizationId(employee.getOrganizationId())
                .departmentId(employee.getDepartmentId())
                .name(employee.getName())
                .position(employee.getPosition())
                .age(employee.getAge())
                .build();
    }

    private Employee mapEmployeeRequestToEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .organizationId(employeeRequest.getOrganizationId())
                .departmentId(employeeRequest.getDepartmentId())
                .name(employeeRequest.getName())
                .position(employeeRequest.getPosition())
                .age(employeeRequest.getAge())
                .build();
    }




}
