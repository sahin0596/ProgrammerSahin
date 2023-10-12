package az.booking.dto.request;

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
public class RentalCarRequest {

    String rentalCompany;

    String carModel;

    String periodTime;

    Double price;

    String pickupLocation;

    String dropOfLocation;

}
