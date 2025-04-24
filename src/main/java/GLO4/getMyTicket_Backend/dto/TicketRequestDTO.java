package GLO4.getMyTicket_Backend.dto;

import GLO4.getMyTicket_Backend.model.Bus;
import GLO4.getMyTicket_Backend.model.Horaire;
import GLO4.getMyTicket_Backend.model.Reservation;
import GLO4.getMyTicket_Backend.model.Trajet;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketRequestDTO {
    @NotNull
    private Long id;

    private Trajet trajet;

    private Bus bus;

    private Horaire horaire;

   private Reservation reservation;
}
