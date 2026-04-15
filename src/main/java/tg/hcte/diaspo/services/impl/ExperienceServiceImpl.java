package tg.hcte.diaspo.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tg.hcte.diaspo.model.Experience;
import tg.hcte.diaspo.repository.ExperienceRepository;
import tg.hcte.diaspo.services.ExperienceService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;

    @Override
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Optional<Experience> getExperienceById(Long id) {
        return experienceRepository.findById(id);
    }

    @Override
    public Experience saveExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public Experience updateExperience(Long id, Experience experience) {
        Experience existingExperience = experienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experience introuvable avec l'id : " + id));

        existingExperience.setPoste(experience.getPoste());
        existingExperience.setEntreprise(experience.getEntreprise());
        existingExperience.setDateDebut(experience.getDateDebut());
        existingExperience.setDateFin(experience.getDateFin());
        existingExperience.setDescription(experience.getDescription());
        existingExperience.setUser(experience.getUser());

        return experienceRepository.save(existingExperience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}