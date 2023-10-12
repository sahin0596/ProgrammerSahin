package az.booking.dto.response;

import az.booking.domain.Booking;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    Long id;

    String name;

    String surname;

    String email;

    String phoneNumber;

    String mail;

    String password;

    List<BookingResponse> booking;
}
