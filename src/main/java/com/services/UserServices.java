package com.services;

import java.util.List;

import com.model.Users;

public interface UserServices {
	public void addUser(Users user);
	public void updatePerson(Users user);
	public List<Users> listPersons();
	public Users getPersonById(int id);
	public void removePerson(int id);
	public boolean isValid(Users user);
}
