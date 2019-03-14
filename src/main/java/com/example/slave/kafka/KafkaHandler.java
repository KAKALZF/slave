package com.example.slave.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 测试：
 * 1：一个生产者，多个消费者,不重复消费消息，如何实现
 * 2：消费者或者kafka宕机，未消费的消息如何处理?
 *     --消费者重新消费了数据（会有重复消费的问题）
 */
@Component
public class KafkaHandler {
    @KafkaListener(topics = {"topicForTest"})
    public void listenT1(ConsumerRecord<String,String> record) throws Exception {
/*        if ("kakalzf0".equals(name)) {
            System.out.println("消费者开始时间:" + new Date());
        }
        System.out.println("消费者1消息:" + name);
        if ("kakalzf99".equals(name)) {
            System.out.println("消费结束时间:" + new Date());
        }*/
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.offset());
        System.out.println(record.partition());
        System.out.println(record.topic());
    }
    /*@KafkaListener(topics = {"mykafka"})
    public void listenT2(String name) throws Exception {
        if (name == "kakalzf0") {
            System.out.println("消费开始时间:" + new Date());
        }
        System.out.println("消费者2消息:" + name);
        if (name == "kakalzf99") {
            System.out.println("消费结束时间:" + new Date());
        }
    }*/

}
