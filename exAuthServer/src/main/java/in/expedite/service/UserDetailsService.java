package in.expedite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import in.expedite.entity.MyUser;
import in.expedite.entity.User;
import in.expedite.entity.UserRole;

@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	@Autowired
    private UserService userService;
	
	private static final Logger LOG = Logger.getLogger(UserDetailsService.class.getName());
	
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    	User user = userService.getUser(userId);
        LOG.info("User : "+user);
        
        if(user==null){
        	 LOG.info("User not found");
            throw new UsernameNotFoundException("Username not found"); 
        }
       
        return new MyUser(user.getUserId(), user.getPassword(), 
            user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user),user.getFirstName(),user.getSecondName(),user.getEmail());
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(UserRole userRole : user.getUserRole()){
          LOG.info("Logged in User Role: "+userRole.getRoleCode());
            authorities.add(new SimpleGrantedAuthority(userRole.getRoleCode()));//+userProfile.getType()));
       }
            LOG.info("authorities :"+authorities);
        return authorities;
    }
     
    static class RandomString {

		  private static final char[] symbols;

		  static {
		    StringBuilder tmp = new StringBuilder();
		    for (char ch = '0'; ch <= '9'; ++ch)
		      tmp.append(ch);
		    for (char ch = 'a'; ch <= 'z'; ++ch)
		      tmp.append(ch);
		    symbols = tmp.toString().toCharArray();
		  }   

		  private final Random random = new Random();

		  private final char[] buf;

		  public RandomString(int length) {
		    if (length < 1)
		      throw new IllegalArgumentException("length < 1: " + length);
		    buf = new char[length];
		  }

		  public String nextString() {
		    for (int idx = 0; idx < buf.length; ++idx) 
		      buf[idx] = symbols[random.nextInt(symbols.length)];
		    return new String(buf);
		  }
		}
}