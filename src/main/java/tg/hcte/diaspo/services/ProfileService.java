package tg.hcte.diaspo.services;

import tg.hcte.diaspo.model.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    List<Profile> getAllProfiles();
    Optional<Profile> getProfileById(Long id);
    Profile saveProfile(Profile profile);
    Profile updateProfile(Long id, Profile profile);
    void deleteProfile(Long id);
}