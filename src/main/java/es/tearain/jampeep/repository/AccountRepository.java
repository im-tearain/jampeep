package es.tearain.jampeep.repository;

import es.tearain.jampeep.model.Account;

public interface AccountRepository {

	Account createAccount();

	Account getAccountById(int id);

	Account getAccountByName(String name);

	void updateAccount();

	void deleteAccount();

	String generatePassword();

}
