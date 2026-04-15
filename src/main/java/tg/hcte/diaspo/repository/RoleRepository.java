package tg.hcte.diaspo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.hcte.diaspo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
