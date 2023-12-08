package az.task.etaskifyms.dto.request.user;

import az.task.etaskifyms.entity.user.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsersListDto {

    List<User> userList = new ArrayList<>();
}
