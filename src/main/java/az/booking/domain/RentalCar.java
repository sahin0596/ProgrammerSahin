package az.booking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "rental_cars")
public class RentalCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String rentalCompany;

    String carModel;

    String periodTime;

    Double price;

    String pickupLocation;

    String dropOfLocation;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    Booking booking;
}
