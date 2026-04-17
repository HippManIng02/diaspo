package tg.hcte.diaspo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tg.hcte.diaspo.model.Competence;
import tg.hcte.diaspo.model.User;

@Data
@AllArgsConstructor
@Builder
public class CompetenceDTO {
    private Long id;
    private String nom;
    private String niveau;
    private Long userId;

    public static CompetenceDTO fromEntity(Competence competence){
        return CompetenceDTO.builder()
                .id(competence.getId())
                .nom(competence.getNom())
                .niveau(competence.getNiveau())
                .userId(competence.getUser().getId())
                .build();
    }

    public static Competence toEntity(CompetenceDTO dto){
        return Competence.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .niveau(dto.getNiveau())
                .user(
                        User.builder()
                                .id(dto.getUserId())
                                .build()
                )
                .build();
    }
}
