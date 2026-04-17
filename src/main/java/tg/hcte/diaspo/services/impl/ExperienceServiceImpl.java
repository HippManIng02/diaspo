package tg.hcte.diaspo.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tg.hcte.diaspo.dto.ExperienceDTO;
import tg.hcte.diaspo.model.Experience;
import tg.hcte.diaspo.model.User;
import tg.hcte.diaspo.repository.ExperienceRepository;
import tg.hcte.diaspo.repository.UserRepository;
import tg.hcte.diaspo.services.ExperienceService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final UserRepository userRepository;

    @Override
    public List<ExperienceDTO> getAllExperiences() {
        return experienceRepository.findAll()
                .stream()
                .map(ExperienceDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ExperienceDTO getExperienceById(Long id) {
        return experienceRepository.findById(id)
                .map(ExperienceDTO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Pas d'expérience trouvée avec cette identifiant."));
    }

    @Override
    public Long saveExperience(ExperienceDTO experience) {
        Experience exp = ExperienceDTO.toEntity(experience);
        return experienceRepository.save(exp).getId();
    }

    @Override
    public ExperienceDTO updateExperience(Long id, ExperienceDTO experienceDTO) {
        Experience existingExperience = experienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experience introuvable avec l'id : " + id));

        existingExperience.setPoste(experienceDTO.getPoste());
        existingExperience.setEntreprise(experienceDTO.getEntreprise());
        existingExperience.setDateDebut(experienceDTO.getDateDebut());
        existingExperience.setDateFin(experienceDTO.getDateFin());
        existingExperience.setDescription(experienceDTO.getDescription());

        if (experienceDTO.getUserID() != null){
            User user = userRepository.findById(experienceDTO.getUserID())
                    .orElseThrow(()-> new EntityNotFoundException("Utilisateur non trouvé."));
            existingExperience.setUser(user);
        }

        Experience exp = experienceRepository.save(existingExperience);
        return ExperienceDTO.fromEntity(exp);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}