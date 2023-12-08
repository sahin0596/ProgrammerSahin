package az.task.etaskifyms.controller;


import az.task.etaskifyms.dto.request.task.TaskCreateRequestDto;
import az.task.etaskifyms.dto.request.user.UsersListDto;
import az.task.etaskifyms.dto.response.task.TaskForUsersResponseDto;
import az.task.etaskifyms.dto.response.task.TaskResponseDto;
import az.task.etaskifyms.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/tasks")
@Slf4j
public class TaskController {

    private  final TaskService taskService;

    @PostMapping("/new")
    public ResponseEntity<TaskResponseDto> create(@RequestBody TaskCreateRequestDto dto){
        return ResponseEntity.ok(taskService.create(dto));
    }

    @PutMapping("/{taskId}/users")
    public ResponseEntity<TaskForUsersResponseDto> assignUsersToTasks(@PathVariable Long taskId,
                                                                      @RequestBody UsersListDto list){
        return ResponseEntity.ok(taskService.assignUsersToTasks(taskId,list));
    }

}
