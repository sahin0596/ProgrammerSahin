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
@Table(name = "flys")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String flightNumber;

    String departureAirport;

    String arrivalAirport;

    String departureTime;

    String arrivalTime;

    String airline;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    @ToString.Exclude
    Booking booking;


}