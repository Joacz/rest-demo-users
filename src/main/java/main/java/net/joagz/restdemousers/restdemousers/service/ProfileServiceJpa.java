package main.java.net.joagz.restdemousers.restdemousers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import main.java.net.joagz.restdemousers.restdemousers.model.Profile;
import main.java.net.joagz.restdemousers.restdemousers.repository.ProfileRepository;

@Service
@Primary
public class ProfileServiceJpa implements IProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findById(int id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.get();
    }

    @Override
    public void deleteById(int id) {
        profileRepository.deleteById(id);
    }

    @Override
    public void save(Profile profile) throws NullPointerException {
        if (profile == null) {
            throw new NullPointerException("Can't save a null object, please provide a valid profile");
        }
        profileRepository.save(profile);
    }

}
