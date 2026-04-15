package tg.hcte.diaspo.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tg.hcte.diaspo.model.Profile;
import tg.hcte.diaspo.repository.ProfileRepository;
import tg.hcte.diaspo.services.ProfileService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Long id, Profile profile) {
        Profile existingProfile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile introuvable avec l'id : " + id));

        existingProfile.setTitle(profile.getTitle());
        existingProfile.setResume(profile.getResume());
        existingProfile.setDesiredLocation(profile.getDesiredLocation());
        existingProfile.setUser(profile.getUser());

        return profileRepository.save(existingProfile);
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}