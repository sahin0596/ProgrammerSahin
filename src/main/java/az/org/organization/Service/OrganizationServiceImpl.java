package az.org.organization.Service;

import az.org.organization.Dto.OrganizationRequest;
import az.org.organization.Dto.OrganizationResponse;

import java.util.List;

public interface OrganizationServiceImpl {
    List<OrganizationResponse> findAll();

    void createOrg(OrganizationRequest organizationRequest);

    OrganizationResponse getOrgId(Long id);

    void update(Long id, OrganizationRequest organizationRequest);

    void delete(Long id);
}
