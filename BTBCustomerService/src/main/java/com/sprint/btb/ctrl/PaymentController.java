package com.sprint.btb.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.PaymentModel;
import com.sprint.btb.service.PaymentServiceImpl;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	@Autowired
	private PaymentServiceImpl paymentService;

	@PostMapping("/create")
	public PaymentModel makePayment(@RequestBody PaymentModel paymentModel) throws BadRequestException {
		return paymentService.addPayment(paymentModel);
	}

	@GetMapping("/")
	public List<PaymentModel> fetchAllPayments() throws BadRequestException {
		return paymentService.getAllPayments();
	}

	@GetMapping("/{paymentId}")
	public PaymentModel fetchPaymentById(@PathVariable("paymentId") int paymentId) throws BadRequestException {
		return paymentService.getPaymentById(paymentId);
	}

	@GetMapping("/customer/{customerId}")
	public List<PaymentModel> getPaymentsByCustomerId(@PathVariable("customerId") int customerId)
			throws BadRequestException {
		return paymentService.getPaymentsByCustomerId(customerId);
	}

	@PutMapping("/update/{paymentId}")
	public PaymentModel updatePaymentById(@PathVariable("paymentId") int paymentId,
			@RequestBody PaymentModel paymentModel) throws BadRequestException {
		return paymentService.updatePaymentById(paymentId, paymentModel);
	}
}
