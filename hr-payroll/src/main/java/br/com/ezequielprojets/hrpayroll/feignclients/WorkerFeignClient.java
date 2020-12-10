package br.com.ezequielprojets.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.ezequielprojets.hrpayroll.entities.Worker;



@Component
@FeignClient(name = "hr-worker", url = "localhost:8002", path = "/workers")
public interface WorkerFeignClient {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> getById(@PathVariable("id") Long id);

}
