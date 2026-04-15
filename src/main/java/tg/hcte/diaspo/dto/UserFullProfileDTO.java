package tg.hcte.diaspo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tg.hcte.diaspo.model.Experience;
import tg.hcte.diaspo.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class UserFullProfileDTO {
    // Information de base
    private UserDTO infoGenerales;

    // Information du profil
    private String title;
    private String resume;
    private String desiredLocation;

    private List<ExperienceDTO> experiences;
    private List<FormationDTO> formations;
    private List<CompetenceDTO> competences;
    private List<LangueDTO> langues;

    public static UserFullProfileDTO fromEntity(User user){
        return UserFullProfileDTO.builder()
                .infoGenerales(UserDTO.fromEntity(user))
                .title(user.getProfile().getTitle())
                .resume(user.getProfile().getResume())
                .desiredLocation(user.getProfile().getDesiredLocation())
                .experiences(
                        user.getExperiences().stream()
                        .map(ExperienceDTO::fromEntity)
                        .collect(Collectors.toList())
                )
                .formations(
                        user.getFormations().stream()
                                .map(FormationDTO::fromEntity)
                                .collect(Collectors.toList())
                )
                .competences(
                        user.getCompetences().stream()
                                .map(CompetenceDTO::fromEntity)
                                .collect(Collectors.toList())
                )
                .langues(
                        user.getLangues().stream()
                                .map(LangueDTO::fromEnity)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
