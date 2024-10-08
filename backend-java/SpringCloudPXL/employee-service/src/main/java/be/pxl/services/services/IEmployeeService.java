package be.pxl.services.services;

import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.EmployeeRequest;
import be.pxl.services.domain.dto.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(Long id);

    EmployeeResponse addEmployee(EmployeeRequest employee);

    List<Employee> getEmployeesByOrganization(Long organizationId);

    List<Employee> getEmployeesByDepartment(Long departmentId);




}
