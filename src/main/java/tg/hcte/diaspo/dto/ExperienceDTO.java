package tg.hcte.diaspo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tg.hcte.diaspo.model.Experience;
import tg.hcte.diaspo.model.User;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceDTO {
    private Long id;
    private String poste;
    private String entreprise;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;
    private Long userID;

    public static ExperienceDTO fromEntity(Experience experience){
        return ExperienceDTO.builder()
                .id(experience.getId())
                .poste(experience.getPoste())
                .entreprise(experience.getEntreprise())
                .dateDebut(experience.getDateDebut())
                .dateFin(experience.getDateFin())
                .description(experience.getDescription())
                .userID(experience.getUser().getId())
                .build();
    }

    public static Experience toEntity(ExperienceDTO dto){
        return Experience.builder()
                .id(dto.getId())
                .poste(dto.getPoste())
                .entreprise(dto.getEntreprise())
                .dateDebut(dto.getDateDebut())
                .dateFin(dto.getDateFin())
                .description(dto.getDescription())
                .user(
                        User.builder()
                                .id(dto.getUserID())
                                .build()
                )
                .build();
    }
}
