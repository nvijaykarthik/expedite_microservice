package in.expedite.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import in.expedite.entity.User;
import in.expedite.repository.UserRepository;

@Component
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void addUser(User user){
		userRepository.save(user);
	}
	
	public User authenticateUser(String userId,final String pwd){
		User user=userRepository.findUserIdQuery(userId);
		if(!pwd.equals(user.getPassword()))
			throw new UsernameNotFoundException("User Password Not Match");
		else
			return user;
	}
	public User getUser(String userId){
		return userRepository.findUserIdQuery(userId);
	}

}
