package tg.hcte.diaspo.services;

import tg.hcte.diaspo.dto.ProfileDTO;
import tg.hcte.diaspo.model.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    List<ProfileDTO> getAllProfiles();
    ProfileDTO getProfileById(Long id);
    Long saveProfile(ProfileDTO profile);
    ProfileDTO updateProfile(Long id, ProfileDTO profile);
    void deleteProfile(Long id);
}