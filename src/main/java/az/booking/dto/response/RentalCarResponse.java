package az.booking.dto.response;

import az.booking.domain.Booking;
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
public class RentalCarResponse {

    Long id;

    String rentalCompany;

    String carModel;

    String periodTime;

    Double price;

    String pickupLocation;

    String dropOfLocation;

    Booking booking;
}
