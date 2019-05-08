package es.tearain.jampeep.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tearain.jampeep.model.HibernateUtilSessionException;
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
	public void createUser(User user) throws HibernateUtilSessionException {
		this.userRepository.createUser(user);
	}

	@Override
	public User getUser(int id) throws HibernateUtilSessionException {
		return this.userRepository.getUser(id);
	}

	@Override
	public User getUser(String name) throws HibernateUtilSessionException {
		return this.userRepository.getUser(name);
	}

	@Override
	public void updateUser(User updatedUser) throws HibernateUtilSessionException {
		this.userRepository.updateUser(updatedUser);
	}

	@Override
	public void removeUser(int id) throws HibernateUtilSessionException {
		this.userRepository.removeUser(id);
	}

	@Override
	public void removeUser(String name) throws HibernateUtilSessionException {
		this.userRepository.removeUser(name);
	}

	@Override
	public void autoManagePasswordOnTrustedDevice() {
		this.userRepository.autoManagePasswordOnTrustedDevice();
	}

}
