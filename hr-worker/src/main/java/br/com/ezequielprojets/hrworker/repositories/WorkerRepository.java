package br.com.ezequielprojets.hrworker.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.ezequielprojets.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepositoryImplementation<Worker, Long>{

}
