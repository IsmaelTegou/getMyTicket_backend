package GLO4.getMyTicket_Backend.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class UserResponseDTO {
    private String numCNI;
    private String firstName;
    private String lastName;
    private Long phone;
    private String email;
}
