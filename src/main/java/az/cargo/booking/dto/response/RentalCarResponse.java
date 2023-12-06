package az.cargo.booking.dto.response;

import az.cargo.booking.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentalCarResponse {
    Long id;

    String rentalCompany;

    String carModel;

    String rentalPeriod;

    String pickUpLocation;

    Booking booking;
}
