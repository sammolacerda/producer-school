package com.example.rabbitmqjava.producerschool.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmqjava.producerschool.domain.Student;
import com.example.rabbitmqjava.producerschool.domain.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/producer")
@AllArgsConstructor
public class SchoolController {

    private AmqpTemplate amqpTemplate;

    @GetMapping("/teacher")
    public String producerTeacher(
            @RequestParam("exchange") String exchange,
            @RequestParam("routingKey") String routingKey,
            @RequestBody Teacher teacher) throws JsonProcessingException {
                 String jsonMessage = new ObjectMapper().writeValueAsString(teacher);
        amqpTemplate.convertAndSend(exchange, routingKey, jsonMessage);
        return "Teacher sent to the RabbitMQ Successfully";
    }

    @GetMapping("/student")
    public String producerStudent(
            @RequestParam("exchange") String exchange,
            @RequestParam("routingKey") String routingKey,
            @RequestBody Student student) throws JsonProcessingException {
                String jsonMessage = new ObjectMapper().writeValueAsString(student);
        amqpTemplate.convertAndSend(exchange, routingKey, jsonMessage);
        return "Student sent to the RabbitMQ Successfully";
    }
}
