package main.java.net.joagz.restdemousers.restdemousers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.net.joagz.restdemousers.restdemousers.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
