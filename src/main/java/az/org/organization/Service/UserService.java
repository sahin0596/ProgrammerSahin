package az.org.organization.Service;


import az.org.organization.Dto.UserRequest;
import az.org.organization.Dto.UserResponse;
import az.org.organization.Model.User;
import az.org.organization.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceImpl{
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user,UserResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public void CreateUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest,User.class);
        userRepository.save(user);
    }

    @Override
    public UserResponse getUserId(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException());
        return modelMapper.map(user,UserResponse.class);
    }

    @Override
    public void update1(Long id, UserRequest userRequest) {
        User user = modelMapper.map(userRequest,User.class);
        userRepository.save(user);
    }

    @Override
    public void delete1(Long id) {
        userRepository.deleteById(id);
    }


}
