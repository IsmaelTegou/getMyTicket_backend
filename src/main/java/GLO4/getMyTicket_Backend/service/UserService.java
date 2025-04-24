package GLO4.getMyTicket_Backend.service;

import GLO4.getMyTicket_Backend.dto.UserRequestDTO;
import GLO4.getMyTicket_Backend.dto.UserResponseDTO;
import GLO4.getMyTicket_Backend.model.User;

import java.util.List;

public interface UserService {
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    public List<UserResponseDTO> getAllUsers();
    public UserResponseDTO getUserById(Long id);
    public User findUserById(Long id);
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);
    public void deleteUser(Long id);
}
