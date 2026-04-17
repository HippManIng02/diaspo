package tg.hcte.diaspo.services;

import tg.hcte.diaspo.dto.UserDTO;
import tg.hcte.diaspo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    Long saveUser(UserDTO user);
    UserDTO updateUser(Long id, UserDTO user);
    void deleteUser(Long id);
}