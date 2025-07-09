package com.spring_microservices.Stock_microservice.controller;


import com.spring_microservices.Base_Domain.model.OrderEvent;
import com.spring_microservices.Stock_microservice.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class stockController {

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @GetMapping("message")
    public ResponseEntity<OrderEvent> getOrder(){
        return new ResponseEntity<>(kafkaConsumer.getOrderEvent(),HttpStatus.OK);
    }
}
