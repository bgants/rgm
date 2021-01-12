package com.gants.rgm.betaservice.config;

import com.gants.rgm.betaservice.models.Employee;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;
import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

@Component
public class MessageConfig {

  @Value("${activemq.broker-url}")
  private String brokerUrl;

  @Bean
  public ConnectionFactory connectionFactory() {
    ConnectionFactory connectionFactory =
        new ActiveMQConnectionFactory(brokerUrl);
    return connectionFactory;
  }

  @Bean
  public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory connectionFactory,
                                                   DefaultJmsListenerContainerFactoryConfigurer configurer) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setMessageConverter(messageConverter());
    configurer.configure(factory, connectionFactory);
    return factory;
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
