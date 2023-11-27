package az.cargo.booking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "books")
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

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    @Builder.Default
    List<Flight> flights = new ArrayList<>();

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    @Builder.Default
    List<Hotel> hotels = new ArrayList<>();

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    @Builder.Default
    List<RentalCar> rentalCars = new ArrayList<>();


    @OneToOne
    @JoinColumn(name = "payment_id")
    @JsonIgnore
    @ToString.Exclude
    Payment payment;







}
