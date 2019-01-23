package com.ascend.activemq.config;

import javax.jms.ConnectionFactory;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

@ComponentScan
@Configuration
@EnableJms
public class ActivemqConfiguration{
	
	Logger logger= LoggerFactory.getLogger(ActivemqConfiguration.class);
	
    @Value("${spring.activemq.broker-url}")
    private String BROKER_URL;
    
    @Bean
    public Topic topic() {
    	logger.info("-================"+BROKER_URL);
        return (Topic)new ActiveMQTopic("sample.topic");
    }
    
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic() {
        final DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory((ConnectionFactory)new ActiveMQConnectionFactory(this.BROKER_URL));
        return (JmsListenerContainerFactory<?>)bean;
    }
    
    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate() {
        return new JmsMessagingTemplate((ConnectionFactory)new ActiveMQConnectionFactory(this.BROKER_URL));
    }
}