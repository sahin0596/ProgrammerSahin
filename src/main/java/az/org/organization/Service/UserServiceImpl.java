package az.org.organization.Service;

import az.org.organization.Dto.UserRequest;
import az.org.organization.Dto.UserResponse;

import java.util.List;

public interface UserServiceImpl {
    List<UserResponse> findAll();


    void CreateUser(UserRequest userRequest);

    UserResponse getUserId(Long id);

    void update1(Long id, UserRequest userRequest);

    void delete1(Long id);
}


