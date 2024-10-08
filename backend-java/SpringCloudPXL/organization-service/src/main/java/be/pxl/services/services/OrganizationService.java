package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Organization;
import be.pxl.services.domain.dto.OrganizationRequest;
import be.pxl.services.domain.dto.OrganizationResponse;
import be.pxl.services.repository.DepartmentRepository;
import be.pxl.services.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService {

    private final OrganizationRepository organizationRepository;
    private final DepartmentRepository departmentRepository;



    public OrganizationResponse getOrganizationById(Long id) {
        Organization organization = organizationRepository.findById(id).orElse(null);
        if (organization != null) {
            return mapOrganizationToResponse(organization);
        }
        return null;
    }


    public OrganizationResponse getOrganizationByIdWithDepartments(Long id) {
        OrganizationResponse organization = getOrganizationById(id);
        if (organization != null) {
            organization.setDepartments(departmentRepository.findByOrganizationId(id));
        }
        return organization;
    }


    public OrganizationResponse getOrganizationByIdWithDepartmentsAndEmployees(Long id) {
        return null;
    }

    public OrganizationResponse getOrganizationByIdWithEmployees(Long id) {
        return null;
    }

    //mapping
    private OrganizationResponse mapOrganizationToResponse(Organization organization) {
        return OrganizationResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .build();
    }

    //mapping
    private Organization mapOrganizationRequestToOrganization(OrganizationRequest organizationRequest) {
        return Organization.builder()
                .name(organizationRequest.getName())
                .address(organizationRequest.getAddress())
                .build();
    }
}
