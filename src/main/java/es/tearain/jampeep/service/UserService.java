package es.tearain.jampeep.service;

import es.tearain.jampeep.model.User;

public interface UserService {

	User createUser();

	User getUserById(int id);

	User getUserByName(String name);

	void updateUser();

	void deleteUser();

	void autoManagePasswordOnTrustedDevice();

}
