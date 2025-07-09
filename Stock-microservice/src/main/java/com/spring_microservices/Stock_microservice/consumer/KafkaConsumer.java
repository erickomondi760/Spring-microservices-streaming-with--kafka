package com.spring_microservices.Stock_microservice.consumer;


import com.spring_microservices.Base_Domain.model.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private NewTopic topic;

    OrderEvent orderEvent;

    public OrderEvent getOrderEvent() {
        return orderEvent;
    }

    @KafkaListener(groupId = "my-group",topics = "topic")
    public void getMessage(OrderEvent orderEvent){
        this.orderEvent = orderEvent;
    }
}
