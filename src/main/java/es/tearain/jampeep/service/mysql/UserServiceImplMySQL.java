package es.tearain.jampeep.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tearain.jampeep.model.User;
import es.tearain.jampeep.repository.UserRepository;
import es.tearain.jampeep.service.UserService;

@Service
public class UserServiceImplMySQL implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImplMySQL(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser() {
		return this.userRepository.createUser();
	}

	@Override
	public User getUserById(int id) {
		return this.userRepository.getUserById(id);
	}

	@Override
	public User getUserByName(String name) {
		return this.userRepository.getUserByName(name);
	}

	@Override
	public void updateUser() {
		this.userRepository.updateUser();
	}

	@Override
	public void deleteUser() {
		this.userRepository.deleteUser();
	}

	@Override
	public void autoManagePasswordOnTrustedDevice() {
		this.userRepository.autoManagePasswordOnTrustedDevice();
	}

}
