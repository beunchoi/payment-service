package com.hanghae.paymentservice.domain.payment.client;

import com.hanghae.paymentservice.domain.payment.event.PaymentSuccessEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "product-service")
public interface ProductServiceClient {

  @PostMapping("/internal/product/decr")
  void decreaseProductStock(@RequestBody PaymentSuccessEvent event);

}