package com.masterdev.sb_kafka_producer.api;

import com.masterdev.sb_kafka_producer.dto.PaymentDTO;
import com.masterdev.sb_kafka_producer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentAPI {
    @Autowired private PaymentService paymentService;

    @PostMapping
    public String pay (@RequestBody PaymentDTO payment) {
        return paymentService.integratePayment(payment);
    }
}
