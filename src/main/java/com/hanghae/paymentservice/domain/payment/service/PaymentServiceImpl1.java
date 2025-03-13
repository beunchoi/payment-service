package com.hanghae.paymentservice.domain.payment.service;

import com.hanghae.paymentservice.domain.payment.entity.Payment;
import com.hanghae.paymentservice.domain.payment.event.OrderCreatedEvent;
import com.hanghae.paymentservice.domain.payment.event.PaymentFailedEvent;
import com.hanghae.paymentservice.domain.payment.event.PaymentSuccessEvent;
import com.hanghae.paymentservice.domain.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl1 implements PaymentService {

  private final PaymentRepository paymentRepository;
  private final ProductEventService productEventService;

  @Override
  @Transactional
  public void completePayment(OrderCreatedEvent event) {
    savePayment(event);

    productEventService.publish(new PaymentSuccessEvent
        (event.getProductId(), event.getOrderId(), event.getQuantity()));
  }

  @Override
  public void savePayment(OrderCreatedEvent event) {
    Payment payment = new Payment(event);
    paymentRepository.save(payment);
  }

  @Override
  public void rollbackPayment(PaymentFailedEvent event) {

  }

}
