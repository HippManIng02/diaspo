package tg.hcte.diaspo.services;

import tg.hcte.diaspo.dto.FormationDTO;
import tg.hcte.diaspo.model.Formation;

import java.util.List;
import java.util.Optional;

public interface FormationService {
    List<FormationDTO> getAllFormations();
    FormationDTO getFormationById(Long id);
    Long saveFormation(FormationDTO formation);
    FormationDTO updateFormation(Long id, FormationDTO formation);
    void deleteFormation(Long id);
}