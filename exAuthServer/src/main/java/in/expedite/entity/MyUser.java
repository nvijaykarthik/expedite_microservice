package in.expedite.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUser extends User {

		private static final long serialVersionUID = -3531439484732724601L;

	     private final String firstName;
	     private final String lastName;
	     private final String email;
	     
		public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
				boolean credentialsNonExpired, boolean accountNonLocked,
				Collection<? extends GrantedAuthority> authorities,String firstName,String lastName,String email) {
			
			super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			this.firstName=firstName;
			this.lastName=lastName;
			this.email=email;
		}

		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public String getEmail() {
			return email;
		}
	
}
