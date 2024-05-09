package net.javaguides.springboot.publisher;

//import org.slf4j.LoggerFactory;

import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.exchange.name}")
    private String routingKey;

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(RabbitMQProducer.class);

    private RabbitTemplate rabbitTemplate;


    public RabbitMQProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent -> %s",message));
        rabbitTemplate.convertAndSend(exchange,routingKey,message);

    }

}
