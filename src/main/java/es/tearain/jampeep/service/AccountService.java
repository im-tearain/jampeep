package es.tearain.jampeep.service;

import es.tearain.jampeep.model.Account;

public interface AccountService {

	Account createAccount();

	Account getAccountById(int id);

	Account getAccountByName(String name);

	void updateAccount();

	void deleteAccount();

	String generatePassword();

}
