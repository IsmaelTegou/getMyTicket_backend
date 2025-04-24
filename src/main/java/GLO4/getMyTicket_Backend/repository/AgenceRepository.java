package GLO4.getMyTicket_Backend.repository;

import GLO4.getMyTicket_Backend.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
