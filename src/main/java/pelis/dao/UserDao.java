package pelis.dao;

import pelis.domain.User;

public interface UserDao {
	User findById(int id);

	User findBySSO(String sso);
}
