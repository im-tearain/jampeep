package es.tearain.jampeep.repository;

import es.tearain.jampeep.model.Account;
import es.tearain.jampeep.model.HibernateUtilSessionException;

public interface AccountRepository {

	void createAccount(Account account) throws HibernateUtilSessionException;

	Account getAccount(int id) throws HibernateUtilSessionException;

	Account getAccount(String name) throws HibernateUtilSessionException;

	void updateAccount(Account updatedAccount) throws HibernateUtilSessionException;

	void removeAccount(int id) throws HibernateUtilSessionException;

	void removeAccount(String name) throws HibernateUtilSessionException;

	String generatePassword();

}
