package az.org.organization.Controller;

import az.org.organization.Dto.OrganizationRequest;
import az.org.organization.Dto.OrganizationResponse;
import az.org.organization.Dto.TaskRequest;
import az.org.organization.Dto.TaskResponse;
import az.org.organization.Service.OrganizationServiceImpl;
import az.org.organization.Service.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/u1/api2")
@RequiredArgsConstructor
public class TaskController {
    private final TaskServiceImpl taskService;

    @GetMapping("/read2")
    public List<TaskResponse> findAll() {
        return taskService.findAll();
    }

    @PostMapping("/create2")
    public void create2(@RequestBody TaskRequest taskRequest) {
        taskService.createTsk(taskRequest);

    }
    @GetMapping("/{id}")
    public TaskResponse getTskId(@PathVariable Long id){
        return taskService.getTskId(id);
    }
    @PutMapping("/{id}")
    public void update2(@PathVariable Long id, @RequestBody TaskRequest taskRequest){
        taskService.update2(id,taskRequest);
    }
    @DeleteMapping("/{id}")
    public void delete2(@PathVariable Long id){
        taskService.delete2(id);
    }
}


