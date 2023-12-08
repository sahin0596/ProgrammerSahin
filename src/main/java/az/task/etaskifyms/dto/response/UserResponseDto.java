package az.task.etaskifyms.dto.response;

import az.task.etaskifyms.entity.address.Address;
import az.task.etaskifyms.entity.phoneNumber.PhoneNumber;
import az.task.etaskifyms.entity.task.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {

    Long id;

    String name;

    String surname;

    List<PhoneNumber> phoneNumbers;

    Address address;

    @Builder.Default
    List<Task> tasks = new ArrayList<>();


}
