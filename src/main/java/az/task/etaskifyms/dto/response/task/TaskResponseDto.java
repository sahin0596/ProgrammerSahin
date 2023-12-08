package az.task.etaskifyms.dto.response.task;
import az.task.etaskifyms.entity.task.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskResponseDto {

    Long id;

    String title;

    String description;

    @JsonFormat(pattern = "dd,MM,yyyy")
    LocalTime deadline;

    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    TaskStatus status;
}
