package com.ascend.activemq.mvc.controller;

import javax.jms.Destination;
import javax.jms.Topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ascend.activemq.jms.Producer;

@Controller
@RequestMapping
public class HomeController{
    @Autowired
    private Producer producer;
    @Autowired
    private Topic topic;
    
    Logger logger=LoggerFactory.getLogger(HomeController.class);
    
    @RequestMapping({ "send.json" })
    @ResponseBody
    public String index() {
    	logger.info("=================================================");
        for (int i = 0; i < 10; ++i) {
            this.producer.sendMessage((Destination)topic, "myname is \u548c\u9e45\u9e45\u9e45\u997f\u9e45\u9e45\u9e45!!!");
        }
        return "index";
    }
}