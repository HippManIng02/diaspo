package tg.hcte.diaspo.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tg.hcte.diaspo.model.Competence;
import tg.hcte.diaspo.repository.CompetenceRepository;
import tg.hcte.diaspo.services.CompetenceService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompetenceServiceImpl implements CompetenceService {

    private final CompetenceRepository competenceRepository;

    @Override
    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    @Override
    public Optional<Competence> getCompetenceById(Long id) {
        return competenceRepository.findById(id);
    }

    @Override
    public Competence saveCompetence(Competence competence) {
        return competenceRepository.save(competence);
    }

    @Override
    public Competence updateCompetence(Long id, Competence competence) {
        Competence existingCompetence = competenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competence introuvable avec l'id : " + id));

        existingCompetence.setNom(competence.getNom());
        existingCompetence.setNiveau(competence.getNiveau());
        existingCompetence.setUser(competence.getUser());

        return competenceRepository.save(existingCompetence);
    }

    @Override
    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }
}