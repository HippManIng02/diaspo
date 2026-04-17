package tg.hcte.diaspo.services;

import tg.hcte.diaspo.dto.ExperienceDTO;
import tg.hcte.diaspo.model.Experience;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {
    List<ExperienceDTO> getAllExperiences();
    ExperienceDTO getExperienceById(Long id);
    Long saveExperience(ExperienceDTO experience);
    ExperienceDTO updateExperience(Long id, ExperienceDTO experience);
    void deleteExperience(Long id);
}