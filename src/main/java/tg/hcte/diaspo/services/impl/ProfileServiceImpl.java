package tg.hcte.diaspo.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tg.hcte.diaspo.dto.ProfileDTO;
import tg.hcte.diaspo.model.Profile;
import tg.hcte.diaspo.model.User;
import tg.hcte.diaspo.repository.ProfileRepository;
import tg.hcte.diaspo.repository.UserRepository;
import tg.hcte.diaspo.services.ProfileService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    @Override
    public List<ProfileDTO> getAllProfiles() {
        return profileRepository.findAll().stream()
                .map(ProfileDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProfileDTO getProfileById(Long id) {
        return profileRepository.findById(id)
                .map(ProfileDTO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Profile non trouvé."));
    }

    @Override
    public Long saveProfile(ProfileDTO profile) {
        Profile p = ProfileDTO.toEntity(profile);
        return profileRepository.save(p).getId();
    }

    @Override
    public ProfileDTO updateProfile(Long id, ProfileDTO profile) {
        Profile existingProfile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile introuvable avec l'id : " + id));

        existingProfile.setTitle(profile.getTitle());
        existingProfile.setResume(profile.getResume());
        existingProfile.setDesiredLocation(profile.getDesiredLocation());

        if ( profile.getUserId() != null){
            User user = userRepository.findById(profile.getUserId())
                    .orElseThrow(()-> new EntityNotFoundException("Utilisateur non trouvé."));
            existingProfile.setUser(user);
        }

        Profile p = profileRepository.save(existingProfile);
        return ProfileDTO.fromEntity(p);
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}