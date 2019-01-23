package com.ascend.activemq.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {

	@JmsListener(destination = "sample.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveQueue(final String text) {
        System.out.println("Consumer1  接受到的数据:" + text);
    }
}
