package tg.hcte.diaspo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "my_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "xxxxxx")
    private String firsname;

    private String lastname;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String tel;
    private String pays;

    @Enumerated(EnumType.STRING)
    private Disponibility disponibility;

    private boolean visible;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Experience> experiences;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Formation> formations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Competence> competences;

    @ManyToMany
    @JoinTable(
            name = "user_languages",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Langue> langues;

    @ManyToMany
    @JoinTable(
            name= "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
