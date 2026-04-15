package tg.hcte.diaspo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tg.hcte.diaspo.model.Competence;

@Data
@AllArgsConstructor
@Builder
public class CompetenceDTO {
    private Long id;
    private String nom;
    private String niveau;

    public static CompetenceDTO fromEntity(Competence competence){
        return CompetenceDTO.builder()
                .id(competence.getId())
                .nom(competence.getNom())
                .niveau(competence.getNiveau())
                .build();
    }

    public static Competence toEntity(CompetenceDTO dto){
        return Competence.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .niveau(dto.getNiveau())
                .build();
    }
}
