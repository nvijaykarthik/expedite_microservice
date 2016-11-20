package in.expedite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.expedite.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserIdAndPassword(String userId,String password); 
	
	@Query("Select u from User u Left join fetch u.userRole where u.userId=?1")
	public User findUserIdQuery(String userId); 
}
