package com.gants.rgm.betaservice.config;

import com.gants.rgm.betaservice.models.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class MessageListener {

  @JmsListener(destination = "new-employee")
  public void handleMessage(Employee message) {
    System.out.println("received: "+message);
  }
}
