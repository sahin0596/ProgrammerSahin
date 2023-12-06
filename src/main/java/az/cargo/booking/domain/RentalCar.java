package az.cargo.booking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "cars")
public class RentalCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String rentalCompany;

    String carModel;

    String rentalPeriod;

    String pickUpLocation;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    @ToString.Exclude
    Booking booking;

}
