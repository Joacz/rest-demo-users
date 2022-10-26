package main.java.net.joagz.restdemousers.restdemousers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.net.joagz.restdemousers.restdemousers.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}