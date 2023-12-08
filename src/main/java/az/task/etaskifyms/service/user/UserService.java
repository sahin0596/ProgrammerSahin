package az.task.etaskifyms.service.user;

import az.task.etaskifyms.dto.request.user.UserCreateRequestDto;
import az.task.etaskifyms.dto.request.user.UserRequestDto;
import az.task.etaskifyms.dto.response.UserCreateResponseDto;
import az.task.etaskifyms.dto.response.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    UserResponseDto get(Long userId);

    UserCreateResponseDto create(UserCreateRequestDto createDto);

    UserResponseDto update(Long id, UserRequestDto requestDto);

    List<UserResponseDto> getAll(Long id);

    UserResponseDto delete(Long userId);
}
