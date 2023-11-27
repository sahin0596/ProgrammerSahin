package az.cargo.booking.service.serviceimpl;

import az.cargo.booking.dto.request.UserRequest;
import az.cargo.booking.dto.response.UserResponse;

import java.util.List;

public interface UserServiceImp {

    List<UserResponse> findAll();


    UserResponse save(UserRequest userRequest);

    UserResponse findById(Long userId);


    UserResponse update(Long userId, UserRequest userRequest);

    void delete(Long userId);
}