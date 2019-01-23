package com.ascend.activemq;

import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.servlet.*;
import org.springframework.boot.context.properties.*;
import javax.jms.*;
import org.apache.activemq.command.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

import org.springframework.boot.*;

@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties
public class Application{
	
	static Logger logger=LoggerFactory.getLogger(Application.class);
	
    @Bean
    public Topic topic() {
        return new ActiveMQTopic("sample.topic");
    }
    
    public static void main(final String[] args) {
    	logger.info("=================================================");
        SpringApplication.run(Application.class, args);
    }
	 

}
