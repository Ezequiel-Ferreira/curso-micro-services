package br.com.ezequielprojets.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ezequielprojets.hroauth.entities.User;
import br.com.ezequielprojets.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private BCryptPasswordEncoder passEn;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.getByEmail(username).getBody();

		if (user == null) {
			logger.error("Email not found" + username);
			
			throw new UsernameNotFoundException("Email not found");
		}
		final String a = this.passEn.encode("123");
		logger.info("Email found: " + username+ "pass: " + a);
		return user;
	}

}
