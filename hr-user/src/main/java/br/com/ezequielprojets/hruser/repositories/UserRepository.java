package br.com.ezequielprojets.hruser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.ezequielprojets.hruser.entities.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Long>{
	Optional<User> findByEmail(String email);
}
