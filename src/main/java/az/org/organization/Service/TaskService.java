package az.org.organization.Service;

import az.org.organization.Dto.OrganizationRequest;
import az.org.organization.Dto.OrganizationResponse;
import az.org.organization.Dto.TaskRequest;
import az.org.organization.Dto.TaskResponse;
import az.org.organization.Model.Organization;
import az.org.organization.Model.Task;
import az.org.organization.Repository.OrganizationRepository;
import az.org.organization.Repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService implements TaskServiceImpl {
    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;

    @Override
    public List<TaskResponse> findAll() {
        return taskRepository
                .findAll()
                .stream()
                .map(organization -> modelMapper.map(organization, TaskResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public void createTsk(TaskRequest taskRequest) {
        Task task = modelMapper.map(taskRequest, Task.class);
        taskRepository.save(task);

    }

    @Override
    public TaskResponse getTskId(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return modelMapper.map(task,TaskResponse.class);
    }

    @Override
    public void update2(Long id,TaskRequest taskRequest) {
       Task task  = modelMapper.map(taskRequest,Task.class);
        taskRepository.save(task);
    }

    @Override
    public void delete2(Long id) {
        taskRepository.deleteById(id);
    }
}
