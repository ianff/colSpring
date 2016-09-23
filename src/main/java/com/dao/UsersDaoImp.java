package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.Users;

@Repository
public class UsersDaoImp implements UsersDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	@Override
	public void updatePerson(Users user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	@Override
	public List<Users> listPersons() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Users";
		Query query = session.createQuery(hql);
		List<Users> userList = query.list();
		return userList;
	}

	@Override
	public Users getPersonById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Users user = (Users) session.load(Users.class, new Integer(id));
		return user;
	}

	@Override
	public void removePerson(int id) {
		Session session = sessionFactory.getCurrentSession();
		Users user = (Users) session.load(Users.class, new Integer(id));
		session.delete(user);
	}

	@Override
	public boolean isValid(Users user) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Users u where u.userName = :username and u.password = :password";
		Query query= session.createQuery(hql);
		query.setParameter("username", user.getUserName());
		query.setParameter("password", user.getPassword());
		List<Users> userList = query.list();
		if(userList.size() == 1) {
			return true;
		} else {
			return false;
		}
	}

}
