package br.com.ezequielprojets.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ezequielprojets.hruser.entities.User;
import br.com.ezequielprojets.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "users")
public class UserResource {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") Long id){
		User user = this.userRepository.findById(id).get();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> getByEmail(@RequestParam String email){
		User user = this.userRepository.findByEmail(email).get();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
