package az.task.etaskifyms.repository;

import az.task.etaskifyms.entity.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
