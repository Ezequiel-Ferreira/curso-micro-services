package br.com.ezequielprojets.hrworker.resources;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ezequielprojets.hrworker.entities.Worker;
import br.com.ezequielprojets.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResourse {
	private static Logger logger = LoggerFactory.getLogger(WorkerResourse.class);

	@Autowired
	private Environment env;

	@Autowired
	private WorkerRepository workerRepo;

	@GetMapping
	public ResponseEntity<List<Worker>> getAll() {
		List<Worker> list = new ArrayList<Worker>();
		this.workerRepo.findAll().stream().forEach(list::add);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> getById(@PathVariable("id") Long id) {
		logger.info("PORT = " + env.getProperty("local.server.port"));

		Worker obj = this.workerRepo.findById(id).get();
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}
