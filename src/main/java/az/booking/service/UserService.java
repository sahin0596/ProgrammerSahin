package az.booking.service;

import az.booking.dto.request.UserRequest;
import az.booking.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> findAll();

    UserResponse save(UserRequest userRequest);

    UserResponse update(UserRequest userRequest);

    UserResponse delete(Long id);
}
