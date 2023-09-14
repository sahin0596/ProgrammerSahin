package az.org.organization.Service;

import az.org.organization.Dto.OrganizationRequest;
import az.org.organization.Dto.OrganizationResponse;
import az.org.organization.Model.Organization;
import az.org.organization.Repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizationService implements OrganizationServiceImpl {
    private final ModelMapper modelMapper;
    private final OrganizationRepository organizationRepository;

    @Override
    public List<OrganizationResponse> findAll() {
        return organizationRepository
                .findAll()
                .stream()
                .map(organization -> modelMapper.map(organization, OrganizationResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public void createOrg(OrganizationRequest organizationRequest) {
        Organization organization = modelMapper.map(organizationRequest, Organization.class);
        organizationRepository.save(organization);

    }

    @Override
    public OrganizationResponse getOrgId(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return modelMapper.map(organization,OrganizationResponse.class);
    }

    @Override
    public void update(Long id, OrganizationRequest organizationRequest) {
        Organization organization = modelMapper.map(organizationRequest,Organization.class);
        organizationRepository.save(organization);
    }

    @Override
    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }


}
