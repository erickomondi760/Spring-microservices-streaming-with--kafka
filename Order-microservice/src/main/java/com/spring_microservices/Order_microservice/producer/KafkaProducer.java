package com.spring_microservices.Order_microservice.producer;


import com.spring_microservices.Base_Domain.model.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    @Autowired
    private NewTopic topic;

    public void sendMessage(OrderEvent order){

        Message<OrderEvent> oderMessage = MessageBuilder.withPayload(order)
                .setHeader(KafkaHeaders.TOPIC,topic.name())
                .build();
        kafkaTemplate.send(oderMessage);
    }
}
