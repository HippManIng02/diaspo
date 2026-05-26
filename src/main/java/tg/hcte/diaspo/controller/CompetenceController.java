package tg.hcte.diaspo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tg.hcte.diaspo.dto.CompetenceDTO;
import tg.hcte.diaspo.services.CompetenceService;

import java.util.List;

@RestController
@RequestMapping("/competences")
@RequiredArgsConstructor
public class CompetenceController {

    private final CompetenceService service;

    @PostMapping("/")
    public ResponseEntity<Long> save(@RequestBody CompetenceDTO competenceDTO){
        return ResponseEntity.ok(service.saveCompetence(competenceDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<CompetenceDTO>> findAll(){
        return ResponseEntity.ok(service.getAllCompetences());
    }

    @GetMapping("/{competence-id}")
    public ResponseEntity<CompetenceDTO> findById(@PathVariable("competence-id") Long competenceId){
        return ResponseEntity.ok(service.getCompetenceById(competenceId));
    }

    @DeleteMapping("/{competence-id}")
    public ResponseEntity<Void> delete(@PathVariable("competence-id") Long competenceId){
        service.deleteCompetence(competenceId);
        return ResponseEntity.accepted().build();
    }


}
