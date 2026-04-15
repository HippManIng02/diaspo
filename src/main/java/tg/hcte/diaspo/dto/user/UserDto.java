package tg.hcte.diaspo.dto.user;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String pays;

    private String disponibility;

    private boolean visible;
}
