package com.sprint.btb.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.sprint.btb.entity.CustomerEntity;
import com.sprint.btb.entity.PaymentEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.CustomerModel;
import com.sprint.btb.model.PaymentModel;
import com.sprint.btb.repo.CustomerRepository;

public class PaymentUtil {
	public static PaymentModel convertPaymentEntityToPaymentModel(PaymentEntity payment) {
		PaymentModel paymentModel = new PaymentModel();
		paymentModel.setPaymentId(payment.getPaymentId());
		paymentModel.setAmount(payment.getAmount());
		paymentModel.setPaymentDate(payment.getPaymentDate());
		paymentModel.setBookingId(payment.getBookingId());

		if (payment.getCustomer() != null) {
			paymentModel.setCustomerId(payment.getCustomer().getCustomerId());
		}

		paymentModel.setPaymentStatus(payment.getPaymentStatus());

		return paymentModel;
	}

	public static PaymentEntity convertPaymentModelToPaymentEntity(PaymentModel paymentModel,
			CustomerRepository customerRepository) throws BadRequestException {
		PaymentEntity payment = new PaymentEntity();
		payment.setPaymentId(paymentModel.getPaymentId());
		payment.setAmount(paymentModel.getAmount());
		payment.setPaymentDate(paymentModel.getPaymentDate());
		payment.setBookingId(paymentModel.getBookingId());

		if (paymentModel.getCustomerId() != 0) {
			CustomerEntity customerEntity = customerRepository.findById(paymentModel.getCustomerId())
					.orElseThrow(() -> new BadRequestException("Customer not found"));
			payment.setCustomer(customerEntity);
		}

		payment.setPaymentStatus(paymentModel.getPaymentStatus());

		return payment;
	}

	public static List<PaymentEntity> convertListOfPaymentModelToPaymentEntity(List<PaymentModel> paymentModelList,
			CustomerRepository customerRepository) throws BadRequestException {
		List<PaymentEntity> paymentEntityList = new ArrayList<>();
		for (PaymentModel pm : paymentModelList) {
			paymentEntityList.add(convertPaymentModelToPaymentEntity(pm, customerRepository));
		}
		return paymentEntityList;
	}

	public static List<PaymentModel> convertListOfPaymentEntityToPaymentModel(List<PaymentEntity> paymentEntity) {
		List<PaymentModel> paymentModelList = new ArrayList<>();
		for (PaymentEntity pe : paymentEntity) {
			paymentModelList.add(convertPaymentEntityToPaymentModel(pe));
		}
		return paymentModelList;
	}
}
