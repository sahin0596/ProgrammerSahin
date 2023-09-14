package az.org.organization.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrganizationResponse {
    private Long id;
    private String holdingName;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate startYear;
    private Integer workers;

}
