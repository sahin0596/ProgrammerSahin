package az.cargo.booking.dto.request;

import az.cargo.booking.dto.response.BookingResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

    String name;

    String surname;

    String email;

    String phoneNumber;

}
