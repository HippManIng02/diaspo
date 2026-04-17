package tg.hcte.diaspo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tg.hcte.diaspo.model.Formation;
import tg.hcte.diaspo.model.User;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class FormationDTO {
    private Long id;
    private String diplome;
    private String ecole;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Long userId;

    public static FormationDTO fromEntity(Formation formation){
        return FormationDTO.builder()
                .id(formation.getId())
                .diplome(formation.getDiplome())
                .ecole(formation.getEcole())
                .dateDebut(formation.getDateDebut())
                .dateFin(formation.getDateFin())
                .userId(formation.getUser().getId())
                .build();
    }

    public static Formation toEntity(FormationDTO dto){
        return Formation.builder()
                .id(dto.getId())
                .diplome(dto.getDiplome())
                .ecole(dto.getEcole())
                .dateDebut(dto.getDateDebut())
                .dateFin(dto.getDateFin())
                .user(
                        User.builder()
                                .id(dto.getUserId())
                                .build()
                )
                .build();
    }
}
