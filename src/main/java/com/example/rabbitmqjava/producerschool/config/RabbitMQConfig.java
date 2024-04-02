package com.example.rabbitmqjava.producerschool.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    Queue teacherQueue() {
        return new Queue("teacher.queue", true);
    }

    @Bean
    Queue studantQueue(){
        return new Queue("student.queue", true);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("direct-exchange");
    }

    @Bean
    Binding teacherBinding(Queue teacherQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(teacherQueue).to(directExchange).with("routingKey.teacher");
    }

    @Bean
    Binding studantBinding(Queue studantQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(studantQueue).to(directExchange).with("routingKey.student");
    }
}
