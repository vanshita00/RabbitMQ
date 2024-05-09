package net.javaguides.springboot.consumer;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//import java.util.logging.Logger;

@Service
public class RabbitMQConsumer {
    private static final Logger LOGGER= (Logger) LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        LOGGER.info(String.format("Received message -> %s",message));
    }
}
