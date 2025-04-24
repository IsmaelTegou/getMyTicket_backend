package GLO4.getMyTicket_Backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDTO {
    @NotBlank(message="Le numero de CNI est obligatoire")
    private String numCNI;

    private String firstName;

    @NotBlank(message="Le nom est obligatoire")
    private String lastName;

    @Size(min=9, message = "Le numero doit avoir au moins 9 caracteres")
    @NotNull
    private Long phone;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    @Size(max = 255, message = "L'email ne doit pas dépasser 255 caractères")
    private String email;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min=4, message = "Le mot de passe doit avoir au moins 4 caracteres")
    private String password;
}
