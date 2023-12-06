package az.cargo.booking.domain;


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
@Table(name = "user_id")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long userId;

    String name;

    String surname;

    String email;

    String phoneNumber;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @Builder.Default
    List<Booking> bookingList = new ArrayList<>();



}
