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
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String hotelName;

    @Enumerated(EnumType.STRING)

    RoomType roomType;

    Double price;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    @ToString.Exclude
    Booking booking;
}