package GLO4.getMyTicket_Backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime reservationDate;

    @Column(nullable = false)
    public boolean status;

    @JsonBackReference
    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

//    @JsonIgnore
//    @OneToOne(mappedBy = "reservation")
//    private Ticket ticket;
}
