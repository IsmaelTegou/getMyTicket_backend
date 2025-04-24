package GLO4.getMyTicket_Backend.dto;

import GLO4.getMyTicket_Backend.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReservationRequestDTO {
    @NotNull
    private Long id;

    @NotNull
    private LocalDateTime reservationDate;

    @NotBlank
    private User user;

}
