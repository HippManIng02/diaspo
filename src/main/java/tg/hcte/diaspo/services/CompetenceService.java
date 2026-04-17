package tg.hcte.diaspo.services;

import tg.hcte.diaspo.dto.CompetenceDTO;
import tg.hcte.diaspo.model.Competence;

import java.util.List;
import java.util.Optional;

public interface CompetenceService {
    List<CompetenceDTO> getAllCompetences();
    CompetenceDTO getCompetenceById(Long id);
    Long saveCompetence(CompetenceDTO competence);
    CompetenceDTO updateCompetence(Long id, CompetenceDTO competence);
    void deleteCompetence(Long id);
}