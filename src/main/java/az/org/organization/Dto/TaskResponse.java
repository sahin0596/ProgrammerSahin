package az.org.organization.Dto;

import az.org.organization.Model.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskResponse {
    private  Long id;
    private  String name;
    Enum<Status> statusEnum;
    private LocalDate deadline;
    private String description;
}
