package tg.hcte.diaspo.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tg.hcte.diaspo.dto.ExperienceDTO;
import tg.hcte.diaspo.services.ExperienceService;

import java.util.List;

@RestController
@RequestMapping("/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private ExperienceService service;

    @PostMapping("/")
    public ResponseEntity<Long> save(@RequestBody ExperienceDTO experienceDTO){
        return ResponseEntity.ok(service.saveExperience(experienceDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<ExperienceDTO>> findAll(){
        return ResponseEntity.ok(service.getAllExperiences());
    }

    @GetMapping("/{experience-id}")
    public ResponseEntity<ExperienceDTO> findById(@PathVariable("experience-id") Long experienceId){
        return ResponseEntity.ok(service.getExperienceById(experienceId));
    }

    @DeleteMapping("/{experience-id}")
    public ResponseEntity<Void> delete(@PathVariable("experience-id") Long experienceId){
        service.deleteExperience(experienceId);
        return ResponseEntity.accepted().build();
    }

}
