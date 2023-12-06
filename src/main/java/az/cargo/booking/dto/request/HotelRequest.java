package az.cargo.booking.dto.request;

import az.cargo.booking.domain.RoomType;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class HotelRequest {
    String hotelName;

    RoomType roomType;

    Double price;
}
