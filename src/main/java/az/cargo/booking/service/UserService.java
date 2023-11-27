package az.cargo.booking.service;

import az.cargo.booking.domain.User;
import az.cargo.booking.dto.request.UserRequest;
import az.cargo.booking.dto.response.UserResponse;
import az.cargo.booking.repository.UserRepository;
import az.cargo.booking.service.serviceimpl.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceImp {

    private final UserRepository userRepository;
    private  final ModelMapper modelMapper;

    @Override
    public List<UserResponse> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user,UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        User user = modelMapper.map(userRequest,User.class);

        User save = userRepository.save(user);

        return modelMapper.map(save,UserResponse.class);

    }

    @Override
    public UserResponse findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(
                String.format("User not found by id -%s", userId)));

    return  modelMapper.map(user,UserResponse.class);

    }

    @Override
    public UserResponse update(Long userId, UserRequest userRequest) {
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException(
                String.format("User not found for updating by id -%s", userId)));
        User responseUser = modelMapper.map(userRequest, User.class);
        responseUser.setUserId(userId);
        return modelMapper.map(userRepository.save(responseUser),UserResponse.class);

    }

    @Override
    public void delete(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException(
                String.format("User not found for deleting by id -%s", userId)));
        userRepository.delete(user);

    }
}

