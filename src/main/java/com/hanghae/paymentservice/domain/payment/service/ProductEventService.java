package com.hanghae.paymentservice.domain.payment.service;

import com.hanghae.paymentservice.domain.payment.client.ProductServiceClient;
import com.hanghae.paymentservice.domain.payment.event.PaymentSuccessEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductEventService {

  private final ProductServiceClient productServiceClient;

  public void publish(PaymentSuccessEvent event) {
    productServiceClient.decreaseProductStock(event);
  }

}
