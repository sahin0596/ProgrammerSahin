package az.booking.service;

import az.booking.domain.User;
import az.booking.dto.request.UserRequest;
import az.booking.dto.response.UserResponse;
import az.booking.repository.UserRepository;
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
    public UserResponse update(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        return modelMapper.map(userRepository.save(user), UserResponse.class);
    }

    @Override
    public UserResponse delete(Long id) {
        User user = modelMapper.map(id, User.class);
        userRepository.deleteById(id);
        return modelMapper.map(userRepository.save(user), UserResponse.class);
    }
}
