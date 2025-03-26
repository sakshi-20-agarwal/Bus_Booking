package com.sprint.btb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sprint.btb.entity.PaymentEntity;
import com.sprint.btb.model.AddressModel;
import com.sprint.btb.model.BookingModel;
import com.sprint.btb.model.PaymentModel;
import com.sprint.btb.model.TripModel;
import com.sprint.btb.repo.CustomerRepository;
import com.sprint.btb.repo.PaymentRepository;
import com.sprint.btb.util.PaymentUtil;

import com.sprint.btb.exception.BadRequestException;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PaymentRepository paymentRepository;

	private static final String BOOKING_SERVICE_URL = "http://localhost:9092/bookings";
	private static final String ADDRESS_SERVICE_URL = "http://localhost:9091/api/addresses";
	private static final String TRIP_SERVICE_URL = "http://localhost:9093/trips";

	@Override
	public PaymentModel getPaymentById(int paymentId) throws BadRequestException {
		PaymentEntity payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new BadRequestException("Payment with given Id not found"));

		

		PaymentModel paymentDTO = PaymentUtil.convertPaymentEntityToPaymentModel(payment);
		return paymentDTO;
	}

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public PaymentModel addPayment(PaymentModel paymentModel) throws BadRequestException {
		try {
			PaymentEntity paymentEntity = PaymentUtil.convertPaymentModelToPaymentEntity(paymentModel,
					customerRepository);
			PaymentEntity savedPayment = paymentRepository.save(paymentEntity);
			return PaymentUtil.convertPaymentEntityToPaymentModel(savedPayment);
		} catch (Exception e) {
			throw new BadRequestException("Invalid payment data");
		}
	}

	@Override
	public List<PaymentModel> getAllPayments() throws BadRequestException {
	    try {
	        List<PaymentEntity> paymentList = paymentRepository.findAll();

	        if (paymentList.isEmpty()) {
	            throw new BadRequestException("No payments found.");
	        }

	        List<PaymentModel> paymentModels = new ArrayList<>();
	        for (PaymentEntity paymentEntity : paymentList) {
	            PaymentModel paymentModel = PaymentUtil.convertPaymentEntityToPaymentModel(paymentEntity);
	            paymentModels.add(paymentModel);
	        }

	        return paymentModels;
	    } catch (Exception e) {
	        throw new BadRequestException("Error fetching all payments: " + e.getMessage());
	    }
	}


	@Override
	public List<PaymentModel> getPaymentsByCustomerId(int customerId) throws BadRequestException {
		try {
			String addressUrl = ADDRESS_SERVICE_URL + "/" + customerId;
			AddressModel address = restTemplate.getForObject(addressUrl, AddressModel.class);

			List<PaymentEntity> payments = paymentRepository.findByCustomer_CustomerId(customerId);

			return payments.stream().map(PaymentUtil::convertPaymentEntityToPaymentModel).collect(Collectors.toList());
		} catch (Exception e) {
			throw new BadRequestException("Error fetching payments for customer ID " + customerId);
		}
	}

	@Override
	public PaymentModel updatePaymentById(int paymentId, PaymentModel paymentModel) throws BadRequestException {
		try {
			PaymentEntity existingPayment = paymentRepository.findById(paymentId)
					.orElseThrow(() -> new BadRequestException("Payment with given Id not found"));

			existingPayment.setAmount(paymentModel.getAmount());
			existingPayment.setPaymentDate(paymentModel.getPaymentDate());
			existingPayment.setBookingId(paymentModel.getBookingId());

			if (paymentModel.getPaymentStatus() != null) {
				existingPayment.setPaymentStatus(paymentModel.getPaymentStatus());
			}

			PaymentEntity updatedPayment = paymentRepository.save(existingPayment);

			return PaymentUtil.convertPaymentEntityToPaymentModel(updatedPayment);
		} catch (Exception e) {
			throw new BadRequestException("Error updating payment with ID " + paymentId);
		}
	}

}
