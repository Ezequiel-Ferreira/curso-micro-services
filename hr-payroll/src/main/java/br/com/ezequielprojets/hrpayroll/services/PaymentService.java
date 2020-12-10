package br.com.ezequielprojets.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ezequielprojets.hrpayroll.entities.Payment;
import br.com.ezequielprojets.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplete;
	
	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+ workerId);

		
		Worker worker = this.restTemplete.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
