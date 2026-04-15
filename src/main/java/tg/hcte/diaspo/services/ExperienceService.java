package tg.hcte.diaspo.services;

import tg.hcte.diaspo.model.Experience;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {
    List<Experience> getAllExperiences();
    Optional<Experience> getExperienceById(Long id);
    Experience saveExperience(Experience experience);
    Experience updateExperience(Long id, Experience experience);
    void deleteExperience(Long id);
}