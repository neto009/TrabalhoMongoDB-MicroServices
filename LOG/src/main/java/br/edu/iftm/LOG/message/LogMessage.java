package br.edu.iftm.LOG.message;

import br.edu.iftm.LOG.entity.Log;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LogMessage {

    @Value("${logSystem.rabbitmq.exchange}")
    String exchange;
    @Value("${logSystem.rabbitmq.routingkey}")
    String routingKey;

    @Autowired
    public RabbitTemplate rabbitTemplate;

    public void sendMessage(Log log) {
        rabbitTemplate.convertAndSend(exchange, routingKey, log);
    }
}
