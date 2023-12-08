package az.task.etaskifyms.entity.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "task")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String description;

    @JsonFormat(pattern = "dd,MM,yyyy")
    LocalDateTime deadline;

    @JsonFormat(pattern = "dd,MM,yyyy")
     LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)

    TaskStatus status;

}
