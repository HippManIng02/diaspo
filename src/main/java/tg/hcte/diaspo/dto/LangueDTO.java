package tg.hcte.diaspo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tg.hcte.diaspo.model.Langue;

@Data
@AllArgsConstructor
@Builder
public class LangueDTO {
    private Long id;
    private String name;
    private String level;


    public static LangueDTO fromEnity(Langue langue){
            return LangueDTO.builder()
                    .id(langue.getId())
                    .name(langue.getName())
                    .level(langue.getLevel())
                    .build();
    }

    public static Langue toEntity(LangueDTO dto){
        return Langue.builder()
                .id(dto.getId())
                .name(dto.getName())
                .level(dto.getLevel())
                .build();
    }
}
