package az.task.etaskifyms.controller;

import az.task.etaskifyms.entity.authority.Authority;
import az.task.etaskifyms.service.Auth.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/authorities")
public class AuthorityController {

    private AuthorityService authorityService;

    @GetMapping
    public List<Authority> getAllAuthorities() {
        return authorityService.getAllAuthorities();
    }

    @GetMapping("/{id}")
    public Authority getAuthorityById(@PathVariable Long id) {
        return authorityService.getAuthorityById(id);
    }

    @PostMapping
    public Authority createAuthority(@RequestBody Authority authority) {
        return authorityService.createAuthority(authority);
    }

    @PutMapping("/{id}")
    public Authority updateAuthority(@PathVariable Long id, @RequestBody Authority authority) {
        return authorityService.updateAuthority(id, authority);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthority(@PathVariable Long id) {
        authorityService.deleteAuthority(id);
    }
}
