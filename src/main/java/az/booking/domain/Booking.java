package az.booking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String bookingDate;

    Double totalCost;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    User user;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @Builder.Default
    List<Flight> flights = new ArrayList<>();

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @Builder.Default
    List<RentalCar> rentalCars = new ArrayList<>();

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @Builder.Default
    List<Hotel> hotels = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "payment_id")
    @JsonIgnore
    @ToString.Exclude
    Payment payment;
}
