package es.tearain.jampeep.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tearain.jampeep.model.Account;
import es.tearain.jampeep.model.HibernateUtilSessionException;
import es.tearain.jampeep.repository.AccountRepository;
import es.tearain.jampeep.service.AccountService;

@Service
public class AccountServiceImplMySQL implements AccountService {

	private final AccountRepository accountRepository;

	@Autowired
	public AccountServiceImplMySQL(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public void createAccount(Account account) throws HibernateUtilSessionException {
		this.accountRepository.createAccount(account);
	}

	@Override
	public Account getAccount(int id) throws HibernateUtilSessionException {
		return this.accountRepository.getAccount(id);
	}

	@Override
	public Account getAccount(String name) throws HibernateUtilSessionException {
		return this.accountRepository.getAccount(name);
	}

	@Override
	public void updateAccount(Account updatedAccount) throws HibernateUtilSessionException {
		this.accountRepository.updateAccount(updatedAccount);
	}

	@Override
	public void removeAccount(int id) throws HibernateUtilSessionException {
		this.accountRepository.removeAccount(id);
	}

	@Override
	public void removeAccount(String name) throws HibernateUtilSessionException {
		this.accountRepository.removeAccount(name);
	}

	@Override
	public String generatePassword() {
		return this.accountRepository.generatePassword();
	}

}
