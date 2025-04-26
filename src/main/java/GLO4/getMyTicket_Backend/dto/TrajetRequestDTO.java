package GLO4.getMyTicket_Backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrajetRequestDTO {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Long idStartAgence;

    @NotNull
    private Long idEndAgence;
}
