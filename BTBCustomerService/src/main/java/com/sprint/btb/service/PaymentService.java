package com.sprint.btb.service;

import java.util.List;

import com.sprint.btb.entity.PaymentEntity;
import com.sprint.btb.model.PaymentModel;

import com.sprint.btb.exception.BadRequestException;

public interface PaymentService {
	PaymentModel getPaymentById(int paymentId) throws BadRequestException;

	PaymentModel addPayment(PaymentModel paymentModel) throws BadRequestException;

	List<PaymentModel> getAllPayments() throws BadRequestException;

	List<PaymentModel> getPaymentsByCustomerId(int customerId) throws BadRequestException;

	PaymentModel updatePaymentById(int paymentId, PaymentModel paymentModel) throws BadRequestException;
}
