package tg.hcte.diaspo.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tg.hcte.diaspo.dto.FormationDTO;
import tg.hcte.diaspo.model.Formation;
import tg.hcte.diaspo.model.User;
import tg.hcte.diaspo.repository.FormationRepository;
import tg.hcte.diaspo.repository.UserRepository;
import tg.hcte.diaspo.services.FormationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final UserRepository userRepository;

    @Override
    public List<FormationDTO> getAllFormations() {
        return formationRepository.findAll()
                .stream()
                .map(FormationDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public FormationDTO getFormationById(Long id) {
        return formationRepository.findById(id)
                .map(FormationDTO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Utilisateur non trouvé."))
                ;
    }

    @Override
    public Long saveFormation(FormationDTO formationDTO) {
        Formation formation = FormationDTO.toEntity(formationDTO);
        return formationRepository.save(formation).getId();
    }

    @Override
    public FormationDTO updateFormation(Long id, FormationDTO formation) {
        Formation existingFormation = formationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formation introuvable avec l'id : " + id));

        existingFormation.setDiplome(formation.getDiplome());
        existingFormation.setEcole(formation.getEcole());
        existingFormation.setDateDebut(formation.getDateDebut());
        existingFormation.setDateFin(formation.getDateFin());

        if (formation.getUserId() != null){
            User user = userRepository.findById(formation.getUserId())
                    .orElseThrow(()-> new EntityNotFoundException("utilisateur non trouvé."));
            existingFormation.setUser(user);
        }

        Formation formation1 = formationRepository.save(existingFormation);
        return FormationDTO.fromEntity(formation1);
    }

    @Override
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }
}