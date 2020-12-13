package br.com.ezequielprojets.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ezequielprojets.hroauth.entities.User;
import br.com.ezequielprojets.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User getByEmail(String email) {
		User user = userFeignClient.getByEmail(email).getBody();
		
		if(user == null) {
			logger.error("Email not found" + email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found: "+  email);
		return user;
	}

}
