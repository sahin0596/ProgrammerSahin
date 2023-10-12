package az.booking.dto.response;

import az.booking.domain.Booking;
import az.booking.domain.RoomType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelResponse {

    Long id;

    String location;

    String hotelName;

    RoomType roomType;

    Double price;

    Booking booking;
}
