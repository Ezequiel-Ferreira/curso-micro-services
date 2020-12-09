package br.com.ezequielprojets.hrworker.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ezequielprojets.hrworker.entities.Worker;
import br.com.ezequielprojets.hrworker.repository.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResourse {
	@Autowired
	private WorkerRepository workerRepo;
	
	public ResponseEntity<List<Worker>> getAll(){
		
		List<Worker> workers = new ArrayList<Worker>();
		this.workerRepo.findAll().stream().forEach(workers::add);
		
		return new ResponseEntity<>(workers, HttpStatus.OK);
		
	}
}
