package main.java.net.joagz.restdemousers.restdemousers.service;

import java.util.List;

import main.java.net.joagz.restdemousers.restdemousers.model.Profile;

public interface IProfileService {
    
    public List<Profile> findAll();

    public Profile findById(int id);

    public void deleteById(int id);

    public void save(Profile profile) throws NullPointerException;

}
