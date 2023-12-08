package az.task.etaskifyms.service.task;


import az.task.etaskifyms.dto.request.task.TaskCreateRequestDto;
import az.task.etaskifyms.dto.request.user.UsersListDto;
import az.task.etaskifyms.dto.response.task.TaskForUsersResponseDto;
import az.task.etaskifyms.dto.response.task.TaskResponseDto;

public interface TaskService {
    TaskResponseDto create(TaskCreateRequestDto requestDto);

    TaskForUsersResponseDto assignUsersToTasks(Long taskId, UsersListDto list);
}
