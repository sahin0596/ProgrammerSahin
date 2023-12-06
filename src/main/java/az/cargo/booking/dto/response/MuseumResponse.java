package az.cargo.booking.dto.response;

import az.cargo.booking.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MuseumResponse {
    Long id;

    String name;

    String address;

    String ticket;

    Double price;

    Booking booking;
}
