package be.pxl.services.controller;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import be.pxl.services.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {


    @Autowired
    private final DepartmentService departmentService;


    @PostMapping("/")
    public ResponseEntity<DepartmentResponse> addDepartment(@RequestBody DepartmentRequest department) {
        DepartmentResponse departmentResponse = departmentService.addDepartment(department);
        return ResponseEntity.ok(departmentResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable Long id) {
        DepartmentResponse department = departmentService.getDepartmentById(id);
        if (department != null) {
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/")
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        List<DepartmentResponse> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }


    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<DepartmentResponse>> getDepartmentsByOrganization(@PathVariable Long organizationId) {
        List<DepartmentResponse> departments = departmentService.getDepartmentsByOrganization(organizationId);
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public ResponseEntity<List<DepartmentResponse>> getDepartmentsByOrganizationWithEmployees(@PathVariable Long organizationId) {
        List<DepartmentResponse> departments = departmentService.getDepartmentsByOrganizationWithEmployees(organizationId);
        return ResponseEntity.ok(departments);
    }


}
