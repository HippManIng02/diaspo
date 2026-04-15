package tg.hcte.diaspo.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tg.hcte.diaspo.model.Formation;
import tg.hcte.diaspo.repository.FormationRepository;
import tg.hcte.diaspo.services.FormationService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Optional<Formation> getFormationById(Long id) {
        return formationRepository.findById(id);
    }

    @Override
    public Formation saveFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public Formation updateFormation(Long id, Formation formation) {
        Formation existingFormation = formationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formation introuvable avec l'id : " + id));

        existingFormation.setDiplome(formation.getDiplome());
        existingFormation.setEcole(formation.getEcole());
        existingFormation.setDateDebut(formation.getDateDebut());
        existingFormation.setDateFin(formation.getDateFin());
        existingFormation.setUser(formation.getUser());

        return formationRepository.save(existingFormation);
    }

    @Override
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }
}