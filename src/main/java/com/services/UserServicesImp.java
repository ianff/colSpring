package com.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.UsersDao;
import com.model.Users;

@Service
public class UserServicesImp implements UserServices{
	
	private UsersDao usersDao;
	
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public void addUser(Users user) {
		usersDao.addUser(user);
	}

	@Override
	public void updatePerson(Users user) {
		usersDao.updatePerson(user);
	}

	@Override
	public List<Users> listPersons() {
		List<Users> userList = usersDao.listPersons();
		return userList;
	}

	@Override
	public Users getPersonById(int id) {
		Users user = usersDao.getPersonById(id);
		return user;
	}

	@Override
	public void removePerson(int id) {
		usersDao.removePerson(id);
	}

	@Override
	public boolean isValid(Users user) {
		if(usersDao.isValid(user)) {
			return true;
		} else {
			return false;
		}
	}

}
