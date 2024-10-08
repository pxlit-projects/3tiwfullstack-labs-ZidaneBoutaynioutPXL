package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;

import java.util.List;

public interface IDepartmentService {

    DepartmentResponse addDepartment(DepartmentRequest department);

    DepartmentResponse getDepartmentById(Long id);

    List<DepartmentResponse> getAllDepartments();

    List<DepartmentResponse> getDepartmentsByOrganization(Long organizationId);

    List<DepartmentResponse> getDepartmentsByOrganizationWithEmployees(Long employeeId);


}
