package tg.hcte.diaspo.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tg.hcte.diaspo.dto.LangueDTO;
import tg.hcte.diaspo.model.Langue;
import tg.hcte.diaspo.repository.LangueRepository;
import tg.hcte.diaspo.services.LangueService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LangueServiceImpl implements LangueService {

    private final LangueRepository langueRepository;

    @Override
    public List<LangueDTO> getAllLangues() {
        return langueRepository.findAll()
                .stream()
                .map(LangueDTO::fromEnity)
                .collect(Collectors.toList());
    }

    @Override
    public LangueDTO getLangueById(Long id) {
        return langueRepository.findById(id)
                .map(LangueDTO::fromEnity)
                .orElseThrow(()-> new EntityNotFoundException("Langue non trouvé avec cette identifiant."));
    }

    @Override
    public Long saveLangue(LangueDTO langue) {
        Langue langue1 = LangueDTO.toEntity(langue);
        return langueRepository.save(langue1).getId();
    }

    @Override
    public LangueDTO updateLangue(Long id, LangueDTO langue) {
        Langue existingLangue = langueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Langue introuvable avec l'id : " + id));

        existingLangue.setName(langue.getName());
        existingLangue.setLevel(langue.getLevel());

        Langue l = langueRepository.save(existingLangue);
        return LangueDTO.fromEnity(l);
    }

    @Override
    public void deleteLangue(Long id) {
        langueRepository.deleteById(id);
    }
}