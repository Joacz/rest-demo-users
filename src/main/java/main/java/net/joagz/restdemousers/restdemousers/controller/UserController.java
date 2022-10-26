package main.java.net.joagz.restdemousers.restdemousers.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.net.joagz.restdemousers.restdemousers.model.User;
import main.java.net.joagz.restdemousers.restdemousers.service.UserServiceJpa;

@RestController
@RequestMapping("/api/users")
@ResponseBody
public class UserController {

    @Autowired
    private UserServiceJpa userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteById(@PathVariable(value = "id") int id) throws NotFoundException {
        User user = userService.findById(id);

        if (user == null) {
            // Return an exception if user is null
            throw new NotFoundException();
        }

        // Delete the user
        userService.deleteById(user.getId());

        // Make a response
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping(path = "/user", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> save(@ModelAttribute User user) throws NullPointerException {

        if (user == null) {
            // Return an exception if user is null
            throw new NullPointerException();
        }

        // Encode password
        String pass_un = user.getPassword();
        String pass_en = passwordEncoder.encode(pass_un);
        user.setPassword(pass_en);

        // Save User
        userService.save(user);
        return new ResponseEntity<User>(HttpStatus.OK);

    }

}
