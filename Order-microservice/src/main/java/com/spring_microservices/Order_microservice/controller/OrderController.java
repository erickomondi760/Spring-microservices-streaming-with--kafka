package com.spring_microservices.Order_microservice.controller;


import com.spring_microservices.Base_Domain.model.Order;
import com.spring_microservices.Base_Domain.model.OrderEvent;
import com.spring_microservices.Order_microservice.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class OrderController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("order")
    public ResponseEntity<String> sendOrder(@RequestBody Order order){
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("Pending");
        orderEvent.setMessage("Sending an order");
        orderEvent.setOrder(order);

        kafkaProducer.sendMessage(orderEvent);
        return ResponseEntity.ok("Order successfully sent");
    }
}
