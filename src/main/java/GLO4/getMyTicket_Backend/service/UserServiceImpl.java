package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.dto.UserRequestDTO;
import GLO4.getMyTicket_Backend.dto.UserResponseDTO;
import GLO4.getMyTicket_Backend.enums.Role;
import GLO4.getMyTicket_Backend.model.User;
import GLO4.getMyTicket_Backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user =
                User.builder()
                        .numCNI(userRequestDTO.getNumCNI())
                        .lastName(userRequestDTO.getLastName())
                        .firstName(userRequestDTO.getFirstName())
                        .phone(userRequestDTO.getPhone())
                        .email(userRequestDTO.getEmail())
                        .password(userRequestDTO.getPassword())
                        .role(Role.CLIENT)
                        .build();

        return mapToDTO(userRepository.save(user));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToDTO).toList();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("user with id " + id + " not found")
        );
        return mapToDTO(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("user with id " + id + " not found")
        );
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = findUserById(id);
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setPhone(userRequestDTO.getPhone());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        userRepository.save(user);

        return mapToDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }

    private UserResponseDTO mapToDTO(User user) {
        return UserResponseDTO.builder()
                .numCNI(user.getNumCNI())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }
}
