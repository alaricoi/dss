package pelis.services;

import pelis.domain.User;

public interface UserService {
	User findById(int id);
    
    User findBySso(String sso);
}
