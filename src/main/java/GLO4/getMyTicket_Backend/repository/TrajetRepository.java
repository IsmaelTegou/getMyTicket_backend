package GLO4.getMyTicket_Backend.repository;

import GLO4.getMyTicket_Backend.model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, Long> {
}
