package main.java.net.joagz.restdemousers.restdemousers.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.net.joagz.restdemousers.restdemousers.model.Profile;
import main.java.net.joagz.restdemousers.restdemousers.service.ProfileServiceJpa;

@RestController
@RequestMapping("/api/profiles")
@ResponseBody
public class ProfileController {

    @Autowired
    private ProfileServiceJpa profileService;

    @GetMapping("")
    public List<Profile> findAll() {
        return profileService.findAll();
    }

    @GetMapping("/profile/{id}")
    public Profile findById(@PathVariable int id) {
        return profileService.findById(id);
    }

    @DeleteMapping("/profile/{id}")
    public Map<String, Boolean> deleteById(@PathVariable int id) throws NotFoundException {

        Profile profile = profileService.findById(id);

        // Handle exceptions
        if (profile == null) {
            throw new NotFoundException();
        }

        // Delete and return the response
        profileService.deleteById(profile.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

    @PostMapping(path = "/profile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Profile> save(@ModelAttribute Profile profile) throws NullPointerException {

        // Handle exceptions
        if (profile == null) {
            throw new NullPointerException();
        }
        // Save the profile
        profileService.save(profile);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
