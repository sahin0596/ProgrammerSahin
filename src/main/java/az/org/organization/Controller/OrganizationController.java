package az.org.organization.Controller;

import az.org.organization.Dto.OrganizationRequest;
import az.org.organization.Dto.OrganizationResponse;
import az.org.organization.Service.OrganizationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationServiceImpl organizationServiceImpl;

    @GetMapping("/read1")
    public List<OrganizationResponse> findAll() {
        return organizationServiceImpl.findAll();
    }

    @PostMapping("/create1")
    public void create(@RequestBody OrganizationRequest organizationRequest) {
        organizationServiceImpl.createOrg(organizationRequest);

    }
    @GetMapping("/{id}")
    public OrganizationResponse getOrgId(@PathVariable Long id){
        return organizationServiceImpl.getOrgId(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody OrganizationRequest organizationRequest){
        organizationServiceImpl.update(id,organizationRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        organizationServiceImpl.delete(id);
    }
}
