package tg.hcte.diaspo.services;

import tg.hcte.diaspo.model.Formation;

import java.util.List;
import java.util.Optional;

public interface FormationService {
    List<Formation> getAllFormations();
    Optional<Formation> getFormationById(Long id);
    Formation saveFormation(Formation formation);
    Formation updateFormation(Long id, Formation formation);
    void deleteFormation(Long id);
}