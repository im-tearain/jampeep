package es.tearain.jampeep.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tearain.jampeep.model.Account;
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
	public Account createAccount() {
		return this.accountRepository.createAccount();
	}

	@Override
	public Account getAccountById(int id) {
		return this.accountRepository.getAccountById(id);
	}

	@Override
	public Account getAccountByName(String name) {
		return this.accountRepository.getAccountByName(name);
	}

	@Override
	public void updateAccount() {
		this.accountRepository.updateAccount();
	}

	@Override
	public void deleteAccount() {
		this.accountRepository.deleteAccount();
	}

	@Override
	public String generatePassword() {
		return this.accountRepository.generatePassword();
	}

}
