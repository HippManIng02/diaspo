package tg.hcte.diaspo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.hcte.diaspo.model.Langue;

public interface LangueRepository extends JpaRepository<Langue, Long> {
}
