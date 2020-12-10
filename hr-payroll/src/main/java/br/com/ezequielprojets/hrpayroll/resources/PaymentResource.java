package br.com.ezequielprojets.hrpayroll.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ezequielprojets.hrpayroll.entities.Payment;
import br.com.ezequielprojets.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResource {
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping(value = "/{workerId}/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long id,@PathVariable("days") Integer days ){
		return new ResponseEntity<>(paymentService.getPayment(id, days), HttpStatus.OK);
	}
}
