package in.expedite.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author vijayakarthik
 * DB entity class for User Table.
 */

@Entity
@Table(name="USER")
public class User {
	
	@Id
	@Column(nullable=false)
	@NotBlank(message="User Id should not be Empty")
	@Pattern(regexp="^[a-zA-Z0-9]*$",message="In Valid User ID")
	private String userId;
	
	@Column(nullable=false)
	@NotBlank(message="First Name should not be Empty")
	@Pattern(regexp="^[a-zA-Z0-9]*$",message="In Valid First Name")
	private String firstName;
	
	@Column(nullable=false)
	@NotBlank(message="Second Name should not be Empty")
	@Pattern(regexp="^[a-zA-Z0-9]*$",message="In Valid Second Name")
	private String secondName;
	
	@Column(nullable=false,unique=true)
	@NotBlank(message="Email should not be Empty")
	@Email(message="Invalid Email")
	private String email;
	
	@Column(nullable=false)
	@NotBlank(message="Password should not be Empty")
	private String password;

	@NotEmpty
	@Column(name="STATE", nullable=false)
	private String state=UserState.ACTIVE.getState();
	
	@OneToMany(mappedBy="user")
	private	Set<UserRole> userRole = new HashSet<>();
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", secondName=" + secondName + ", email=" + email
				+ ", password=[PROTECTED], state=" + state + ", userRole=" + userRole + "]";
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	
	
}
