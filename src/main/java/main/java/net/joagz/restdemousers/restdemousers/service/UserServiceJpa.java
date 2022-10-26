package main.java.net.joagz.restdemousers.restdemousers.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import main.java.net.joagz.restdemousers.restdemousers.model.User;
import main.java.net.joagz.restdemousers.restdemousers.repository.UserRepository;

@Service
@Primary
public class UserServiceJpa implements IUserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void save(User user) throws NullPointerException {
        if (user == null) {
            throw new NullPointerException("Can't save a null object, please provide a valid user");
        }
        userRepository.save(user);
    }

   

}
