package tg.hcte.diaspo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.hcte.diaspo.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
