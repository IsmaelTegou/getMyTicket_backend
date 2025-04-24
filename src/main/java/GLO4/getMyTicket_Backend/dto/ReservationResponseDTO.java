package GLO4.getMyTicket_Backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReservationResponseDTO {
    private Long id;
    private boolean status;
    private String numCNIClient;
    private LocalDateTime reservationDate;
    private String firstNameClient;
    private String lastNameClient;
}
