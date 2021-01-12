package com.gants.rgm.alphaservice.services;

import com.gants.rgm.alphaservice.models.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageProducer {
  @Autowired
  JmsTemplate jmsTemplate;

  @Value("${activemq.topic}")
  private String topic;

  public void sendMessage(Employee message){
    try{
      log.info("Attempting Send message to Topic: "+ topic);
      log.info("Send new employee: "+ message.toString());
      jmsTemplate.convertAndSend(topic, message);
    } catch(Exception e){
      log.error("Received Exception during send Message: ", e);
    }
  }
}
