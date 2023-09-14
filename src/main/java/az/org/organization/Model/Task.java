package az.org.organization.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@Data
@Entity
@RequiredArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    Enum<Status> statusEnum;
    private LocalDate deadline;
    private String description;

}
