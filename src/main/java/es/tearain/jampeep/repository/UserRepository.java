package es.tearain.jampeep.repository;

import es.tearain.jampeep.model.HibernateUtilSessionException;
import es.tearain.jampeep.model.User;

public interface UserRepository {

	void createUser(User user) throws HibernateUtilSessionException;

	User getUser(int id) throws HibernateUtilSessionException;

	User getUser(String name) throws HibernateUtilSessionException;

	void updateUser(User updatedUser) throws HibernateUtilSessionException;

	void removeUser(int id) throws HibernateUtilSessionException;

	void removeUser(String Name) throws HibernateUtilSessionException;

	void autoManagePasswordOnTrustedDevice();

}
