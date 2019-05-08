package es.tearain.jampeep.repository;

import es.tearain.jampeep.model.User;

public interface UserRepository {

	User createUser();

	User getUserById(int id);

	User getUserByName(String name);

	void updateUser();

	void deleteUser();

	void autoManagePasswordOnTrustedDevice();

}
