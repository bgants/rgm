package com.gants.rgm.alphaservice.config;

import com.gants.rgm.alphaservice.models.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class MessageConfig {

  @Value("${activemq.broker-url}")
  private String brokerUrl;

  @Bean
  public ConnectionFactory connectionFactory(){
    ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
    log.info("Grabbed broker url : " + brokerUrl + " and setting on connectionFactory.");
    activeMQConnectionFactory.setBrokerURL(brokerUrl);
    return  activeMQConnectionFactory;
  }

  @Bean
  public MappingJackson2MessageConverter messageConverter() {
    MappingJackson2MessageConverter messageConverter =
        new MappingJackson2MessageConverter();
    messageConverter.setTypeIdPropertyName("_typeId");

    Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
    typeIdMappings.put("employee-message", Employee.class);
    messageConverter.setTypeIdMappings(typeIdMappings);

    return messageConverter;
  }
}
