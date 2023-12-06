package az.cargo.booking.dto.request;

import az.cargo.booking.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MuseumRequest {

    String name;

    String address;

    String ticket;

    Double price;

}
