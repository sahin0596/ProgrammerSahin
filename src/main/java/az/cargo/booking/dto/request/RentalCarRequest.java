package az.cargo.booking.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentalCarRequest {
    String rentalCompany;

    String carModel;

    String rentalPeriod;

    String pickUpLocation;

}
