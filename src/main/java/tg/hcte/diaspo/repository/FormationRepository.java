package tg.hcte.diaspo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.hcte.diaspo.model.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {
}
