package GLO4.getMyTicket_Backend.model;

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
@Table(name="tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Trajet trajet;

    @ManyToOne
    private Bus bus;

    @ManyToOne
    private Horaire horaire;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Reservation reservation;
}
