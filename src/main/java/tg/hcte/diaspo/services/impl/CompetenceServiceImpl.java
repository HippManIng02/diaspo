package tg.hcte.diaspo.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tg.hcte.diaspo.dto.CompetenceDTO;
import tg.hcte.diaspo.model.Competence;
import tg.hcte.diaspo.model.User;
import tg.hcte.diaspo.repository.CompetenceRepository;
import tg.hcte.diaspo.repository.UserRepository;
import tg.hcte.diaspo.services.CompetenceService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompetenceServiceImpl implements CompetenceService {

    private final CompetenceRepository competenceRepository;
    private final UserRepository userRepository;

    @Override
    public List<CompetenceDTO> getAllCompetences() {
        return competenceRepository.findAll()
                .stream()
                .map(CompetenceDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CompetenceDTO getCompetenceById(Long id) {
        return competenceRepository.findById(id)
                .map(CompetenceDTO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Pas de compétence trouvée avec cette identifiant."));
    }

    @Override
    public Long saveCompetence(CompetenceDTO competence) {
        Competence cmpte = CompetenceDTO.toEntity(competence);
        return competenceRepository.save(cmpte).getId();
    }

    @Override
    public CompetenceDTO updateCompetence(Long id, CompetenceDTO competence) {
        Competence existingCompetence = competenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competence introuvable avec l'id : " + id));

        existingCompetence.setNom(competence.getNom());
        existingCompetence.setNiveau(competence.getNiveau());

        if (competence.getUserId() != null) {
            User user = userRepository.findById(competence.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));
            existingCompetence.setUser(user);
        }

        Competence cpte = competenceRepository.save(existingCompetence);
        return CompetenceDTO.fromEntity(cpte);
    }

    @Override
    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }
}