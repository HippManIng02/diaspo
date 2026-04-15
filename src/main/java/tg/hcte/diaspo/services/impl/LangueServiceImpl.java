package tg.hcte.diaspo.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tg.hcte.diaspo.model.Langue;
import tg.hcte.diaspo.repository.LangueRepository;
import tg.hcte.diaspo.services.LangueService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LangueServiceImpl implements LangueService {

    private final LangueRepository langueRepository;

    @Override
    public List<Langue> getAllLangues() {
        return langueRepository.findAll();
    }

    @Override
    public Optional<Langue> getLangueById(Long id) {
        return langueRepository.findById(id);
    }

    @Override
    public Langue saveLangue(Langue langue) {
        return langueRepository.save(langue);
    }

    @Override
    public Langue updateLangue(Long id, Langue langue) {
        Langue existingLangue = langueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Langue introuvable avec l'id : " + id));

        existingLangue.setName(langue.getName());
        existingLangue.setLevel(langue.getLevel());


        return langueRepository.save(existingLangue);
    }

    @Override
    public void deleteLangue(Long id) {
        langueRepository.deleteById(id);
    }
}