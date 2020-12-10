package br.com.ezequielprojets.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ezequielprojets.hrpayroll.entities.Payment;
import br.com.ezequielprojets.hrpayroll.entities.Worker;
import br.com.ezequielprojets.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeingClient; 
	
	public Payment getPayment(long workerId, int days) {
		
		Worker worker = this.workerFeingClient.getById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
