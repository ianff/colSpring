package com.dao;

import java.util.List;

import com.model.Users;

public interface UsersDao {
	public void addUser(Users user);
	public void updatePerson(Users user);
	public List<Users> listPersons();
	public Users getPersonById(int id);
	public void removePerson(int id);
	public boolean isValid(Users user);
}
