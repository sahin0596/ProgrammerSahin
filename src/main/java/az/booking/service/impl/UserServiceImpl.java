package az.booking.service.impl;

import az.booking.domain.User;
import az.booking.dto.request.UserRequest;
import az.booking.dto.response.UserResponse;
import az.booking.errors.ApplicationException;
import az.booking.errors.Errors;
import az.booking.repository.UserRepository;
import az.booking.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;


    @Override
    public List<UserResponse> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        return modelMapper.map(userRepository.save(user), UserResponse.class);
    }

    @Override
    public User update(Long userId, UserRequest userRequest) {
        userRepository.findById(userId).orElseThrow(() -> new ApplicationException(Errors.USER_NOT_FOUND));
        User responseUser = modelMapper.map(userRequest, User.class);
        responseUser.setUserId(userId);
        return modelMapper.map(userRepository.save(responseUser), User.class);
    }

    @Override
    public void delete(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ApplicationException(Errors.USER_NOT_FOUND));
        userRepository.delete(user);
    }

    @Override
    public UserResponse findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ApplicationException(Errors.USER_NOT_FOUND));
        return modelMapper.map(user, UserResponse.class);
    }
}
