package com.nowcoder.community.event;

import com.alibaba.fastjson.JSONObject;
import com.nowcoder.community.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    // Handle events
    public void fireEvent(Event event) {
        // Publish events to the specified topic
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));


    }
}
