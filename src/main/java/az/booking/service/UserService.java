package az.booking.service;

import az.booking.domain.User;
import az.booking.dto.request.UserRequest;
import az.booking.dto.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserResponse> findAll();

    UserResponse save(UserRequest userRequest);

    User update(Long userId, UserRequest userRequest);

    void delete(Long userId);

    UserResponse findById(Long userId);
}
