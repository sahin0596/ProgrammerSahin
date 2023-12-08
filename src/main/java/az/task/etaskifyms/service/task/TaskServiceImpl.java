package az.task.etaskifyms.service.task;
import az.task.etaskifyms.dto.request.task.TaskCreateRequestDto;
import az.task.etaskifyms.dto.request.user.UsersListDto;
import az.task.etaskifyms.dto.response.task.TaskForUsersResponseDto;
import az.task.etaskifyms.dto.response.task.TaskResponseDto;
import az.task.etaskifyms.entity.task.Task;
import az.task.etaskifyms.entity.task.TaskStatus;
import az.task.etaskifyms.entity.user.User;
import az.task.etaskifyms.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final ModelMapper modelMapper;

    public TaskResponseDto create(TaskCreateRequestDto requestDto) {
        Task newTask = Task.builder()
                .title(requestDto.getTitle())
                .description(requestDto.getDescription())
                .deadline(requestDto.getDeadline())
                .status(TaskStatus.NEW)
                .build();
        Task savedTask = taskRepository.save(newTask);
        return modelMapper.map(savedTask, TaskResponseDto.class);
    }

    public TaskForUsersResponseDto assignUsersToTasks(Long taskId, UsersListDto list) {
        Task task = taskRepository.findById(taskId).orElseThrow(() ->
                new RuntimeException(String.format("Task with id %s not found", taskId)));

        for (User user : list.getUserList()) {
            user.getTasks().add(task);
        }
        TaskForUsersResponseDto taskForUsersResponseDto = modelMapper.map(task, TaskForUsersResponseDto.class);
        taskForUsersResponseDto.setUserList(list.getUserList());
        return taskForUsersResponseDto;
    }
}
