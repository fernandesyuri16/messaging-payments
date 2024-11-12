package com.masterdev.sb_kafka_producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.masterdev.sb_kafka_producer.dto.PaymentDTO;
import com.masterdev.sb_kafka_producer.producer.PaymentRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired private PaymentRequestProducer paymentRequestProducer;

    public String integratePayment (PaymentDTO payment) {
        try {
            return paymentRequestProducer.sendMessage(payment);
        } catch (JsonProcessingException e) {
            return "Houve um erro ao solicitar pagamento"+ e.getMessage();
        }
    }
}
