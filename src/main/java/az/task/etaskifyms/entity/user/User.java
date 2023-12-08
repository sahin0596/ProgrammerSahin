package az.task.etaskifyms.entity.user;

import az.task.etaskifyms.entity.address.Address;
import az.task.etaskifyms.entity.authority.Authority;
import az.task.etaskifyms.entity.organization.Organization;
import az.task.etaskifyms.entity.phoneNumber.PhoneNumber;
import az.task.etaskifyms.entity.task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.parameters.P;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    String name;

    String surname;

    String email;

    String password;

    @ManyToOne
    @JsonIgnore   //request atanda gostermesin
    @ToString.Exclude
    Organization organization;

    @OneToOne(cascade = CascadeType.ALL)

    @JsonIgnore
    @ToString.Exclude
    Address address;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @Builder.Default
    List<PhoneNumber> phoneNumbers = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)

    @Builder.Default
    @JoinTable(name = "users_tasks",
    joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "task_id",referencedColumnName = "id"))
    List<Task> tasks = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)

    @Builder.Default
    @JoinTable(name = "users_tasks",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"))
    List<Task> task = new ArrayList<>();


    @ManyToMany
    @Builder.Default
    @JoinTable(
            name = "user_authorities",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    List<Authority> authorities = new ArrayList<>();
}
