package GLO4.getMyTicket_Backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrajetResponseDTO {
    private Long id;
    private String name;
    private Double price;
    private Long idStartAgence;
    private String startAgenceName;
    private String startAgenceCity;
    private Long idEndAgence;
    private String endAgenceName;
    private String endAgenceCity;
}
