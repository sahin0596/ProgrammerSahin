package az.task.etaskifyms.dto.response;

import jakarta.validation.constraints.AssertFalse;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateResponseDto {

    String message;


}
