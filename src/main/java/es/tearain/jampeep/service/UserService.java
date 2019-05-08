package es.tearain.jampeep.service;

import es.tearain.jampeep.model.HibernateUtilSessionException;
import es.tearain.jampeep.model.User;

public interface UserService {

	void createUser(User user) throws HibernateUtilSessionException;

	User getUser(int id) throws HibernateUtilSessionException;

	User getUser(String name) throws HibernateUtilSessionException;

	void updateUser(User updatedUser) throws HibernateUtilSessionException;

	void removeUser(int id) throws HibernateUtilSessionException;

	void removeUser(String name) throws HibernateUtilSessionException;

	void autoManagePasswordOnTrustedDevice();

}
