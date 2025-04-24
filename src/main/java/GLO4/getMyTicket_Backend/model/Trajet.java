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
@Table(name="trajets")
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name =  "agence_depart_id")
    private Agence startAgence;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name =  "agence_arrivee_id")
    private Agence endAgence;

}
