package com.masterdev.sb_kafka_producer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterdev.sb_kafka_producer.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentRequestProducer {
    @Value("${topics.payment.request.topic}")
    private String topicPaymentRequest;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String sendMessage(PaymentDTO payment) throws JsonProcessingException {
        String content = objectMapper.writeValueAsString(payment);
        kafkaTemplate.send(topicPaymentRequest, content);
        return "Pagamento enviado para processamento...";
    }
}
