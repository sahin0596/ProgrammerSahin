package az.cargo.booking.dto.response;

import az.cargo.booking.domain.Booking;
import az.cargo.booking.domain.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelResponse {
    Long id;

    String hotelName;

    RoomType roomType;

    Double price;

    Booking booking;
}
