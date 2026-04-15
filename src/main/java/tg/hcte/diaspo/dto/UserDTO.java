package tg.hcte.diaspo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tg.hcte.diaspo.model.Disponibility;
import tg.hcte.diaspo.model.User;

@Data
@Builder
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String tel;
    private String pays;
    private Disponibility disponibility;
    private boolean visible;

    public static UserDTO fromEntity(User user){
        return UserDTO.builder()
                .id(user.getId())
                .firstname(user.getFirsname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .tel(user.getTel())
                .pays(user.getPays())
                .disponibility(user.getDisponibility())
                .visible(user.isVisible())
                .build();
    }

    public static User toEntity(UserDTO dto){
        return User.builder()
                .id(dto.getId())
                .firsname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .tel(dto.getTel())
                .pays(dto.getPays())
                .disponibility(dto.getDisponibility())
                .visible(dto.isVisible())
                .build();
    }
}
