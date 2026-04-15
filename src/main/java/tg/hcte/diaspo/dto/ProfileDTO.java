package tg.hcte.diaspo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tg.hcte.diaspo.model.Profile;

@Data
@Builder
@AllArgsConstructor
public class ProfileDTO {
    private Long id;
    private String title;
    private String resume;
    private String desiredLocation;

    public static ProfileDTO fromEntity(Profile profile){
        return ProfileDTO.builder()
                .id(profile.getId())
                .title(profile.getTitle())
                .resume(profile.getResume())
                .desiredLocation(profile.getDesiredLocation())
                .build();
    }

    public static Profile toEntity(ProfileDTO dto){
        return Profile.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .resume(dto.getResume())
                .desiredLocation(dto.getDesiredLocation())
                .build();
    }
}
