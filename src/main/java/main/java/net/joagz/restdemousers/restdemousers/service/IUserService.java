package main.java.net.joagz.restdemousers.restdemousers.service;

import java.util.List;

import main.java.net.joagz.restdemousers.restdemousers.model.User;

public interface IUserService {
	public List<User> findAll();

	public User findById(int id);

	public void deleteById(int id);

	public void save(User user) throws NullPointerException;
}
