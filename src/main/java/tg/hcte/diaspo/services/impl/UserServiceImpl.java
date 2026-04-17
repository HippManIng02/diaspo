package tg.hcte.diaspo.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tg.hcte.diaspo.dto.UserDTO;
import tg.hcte.diaspo.model.User;
import tg.hcte.diaspo.repository.UserRepository;
import tg.hcte.diaspo.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserDTO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Unitilisateur non trouvé."));
    }

    @Override
    public Long saveUser(UserDTO user) {
        User u = UserDTO.toEntity(user);
        return userRepository.save(u).getId();
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec l'id : " + id));

        existingUser.setFirsname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        existingUser.setTel(user.getTel());
        existingUser.setPays(user.getPays());
        existingUser.setDisponibility(user.getDisponibility());
        existingUser.setVisible(user.isVisible());

        User u = userRepository.save(existingUser);
        return UserDTO.fromEntity(u);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}