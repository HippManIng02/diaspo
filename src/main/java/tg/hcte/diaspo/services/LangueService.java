package tg.hcte.diaspo.services;

import tg.hcte.diaspo.dto.LangueDTO;
import tg.hcte.diaspo.model.Langue;

import java.util.List;
import java.util.Optional;

public interface LangueService {
    List<LangueDTO> getAllLangues();
    LangueDTO getLangueById(Long id);
    Long saveLangue(LangueDTO langue);
    LangueDTO updateLangue(Long id, LangueDTO langue);
    void deleteLangue(Long id);
}