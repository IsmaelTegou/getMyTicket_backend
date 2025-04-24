package GLO4.getMyTicket_Backend.model;

import GLO4.getMyTicket_Backend.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    private String numCNI;

    @Column(nullable = false)
    private String lastName;

    private String firstName;

    @Column(nullable = false)
    private Long phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Role role;

//    @JsonManagedReference
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "client")
//    private List<Reservation> listReservations;

}
