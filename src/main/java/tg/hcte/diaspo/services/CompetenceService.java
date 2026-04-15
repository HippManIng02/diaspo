package tg.hcte.diaspo.services;

import tg.hcte.diaspo.model.Competence;

import java.util.List;
import java.util.Optional;

public interface CompetenceService {
    List<Competence> getAllCompetences();
    Optional<Competence> getCompetenceById(Long id);
    Competence saveCompetence(Competence competence);
    Competence updateCompetence(Long id, Competence competence);
    void deleteCompetence(Long id);
}