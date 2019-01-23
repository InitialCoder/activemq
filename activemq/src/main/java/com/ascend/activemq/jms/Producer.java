package com.ascend.activemq.jms;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service("producer")
public class Producer{
    @Autowired
    private JmsMessagingTemplate jmsTemplate;
    
    public void sendMessage(Destination destination, String message) {
    	jmsTemplate.convertAndSend(destination, message);
    }
}