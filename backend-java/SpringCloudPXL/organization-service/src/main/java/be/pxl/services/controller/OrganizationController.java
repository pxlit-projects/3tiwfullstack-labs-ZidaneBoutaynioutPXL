package be.pxl.services.controller;

import be.pxl.services.domain.Organization;
import be.pxl.services.domain.dto.OrganizationResponse;
import be.pxl.services.services.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    // Get organization by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponse> getOrganizationById(@PathVariable Long id) {
        OrganizationResponse organization = organizationService.getOrganizationById(id);
        return organization != null ? ResponseEntity.ok(organization) : ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}/with-departments")
    public ResponseEntity<OrganizationResponse> getOrganizationByIdWithDepartments(@PathVariable Long id) {
        OrganizationResponse organization = organizationService.getOrganizationByIdWithDepartments(id);
        return organization != null ? ResponseEntity.ok(organization) : ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}/with-departments-and-employees")
    public ResponseEntity<OrganizationResponse> getOrganizationByIdWithDepartmentsAndEmployees(@PathVariable Long id) {
        OrganizationResponse organization = organizationService.getOrganizationByIdWithDepartmentsAndEmployees(id);
        return organization != null ? ResponseEntity.ok(organization) : ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}/with-employees")
    public ResponseEntity<OrganizationResponse> getOrganizationByIdWithEmployees(@PathVariable Long id) {
        OrganizationResponse organization = organizationService.getOrganizationByIdWithEmployees(id);
        return organization != null ? ResponseEntity.ok(organization) : ResponseEntity.notFound().build();
    }
}
