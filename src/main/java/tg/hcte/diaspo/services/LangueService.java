package tg.hcte.diaspo.services;

import tg.hcte.diaspo.model.Langue;

import java.util.List;
import java.util.Optional;

public interface LangueService {
    List<Langue> getAllLangues();
    Optional<Langue> getLangueById(Long id);
    Langue saveLangue(Langue langue);
    Langue updateLangue(Long id, Langue langue);
    void deleteLangue(Long id);
}