package az.cargo.booking.dto.response;

import az.cargo.booking.domain.Booking;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {
    Long paymentId;

    Double paymentAmount;

    String paymentMethod;

    String paymentDate;

    Booking booking;
}
