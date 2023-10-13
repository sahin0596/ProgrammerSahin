package az.booking.service;

import az.booking.dto.request.UserRequest;
import az.booking.dto.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserResponse> findAll();

    UserResponse save(UserRequest userRequest);

    UserResponse update(UserRequest userRequest);

    UserResponse delete(Long id);

    UserResponse findById(Long id);
}
