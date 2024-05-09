package net.javaguides.springboot.publisher;

import net.javaguides.springboot.dto.User;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//import java.util.logging.Logger;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    private RabbitTemplate rabbitTemplate;

    private RabbitMQJsonProducer(RabbitTemplate rabbitTemplate){
       this.rabbitTemplate=rabbitTemplate;
    }

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("Json message sent -> %s",user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,user);

    }
}
