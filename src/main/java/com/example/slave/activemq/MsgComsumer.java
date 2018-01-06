package com.example.slave.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * Created by 1 on 2017/12/17.
 */
@Component
public class MsgComsumer {
    @Autowired
    private JmsTemplate jmsTemplate;
    Destination destination = new ActiveMQQueue("createOrder");


//  消费者,写在另一个系统
    @JmsListener(destination = "createOrder")
    public void comsumerMsg(Long userId) {
        System.out.println(userId);
    }
}
