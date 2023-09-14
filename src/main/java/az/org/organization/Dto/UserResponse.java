package az.org.organization.Dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
}
