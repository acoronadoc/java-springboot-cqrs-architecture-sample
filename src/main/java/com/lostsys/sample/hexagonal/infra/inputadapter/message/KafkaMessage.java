package com.lostsys.sample.hexagonal.infra.inputadapter.message;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.lostsys.sample.hexagonal.infra.inputport.MessageBrokerInputPort;
import com.lostsys.sample.hexagonal.infra.utils.ConversionUtils;

@Service
public class KafkaMessage {

    @Autowired
    MessageBrokerInputPort messageBrokerInputPort;

    @KafkaListener(topicPattern = "dbserver1.public.*", groupId = "group1")
    public void consumeEvent( @Payload( required = false ) String eventMsg ) {
        if ( eventMsg == null ) return;

        Map<String, Object> event = ConversionUtils.jsonstring2Map( eventMsg );

        Map<String, Object> payload = (Map<String, Object>) event.get("payload");
        String operation = (String) payload.get("op");
        String table = (String) ((Map<String, Object>) payload.get("source")).get("table");

        if ( operation.equals("u") ) {
            messageBrokerInputPort.updateReg(table, (Map<String, Object>) payload.get("after"));
        } else if ( operation.equals("c") ) {
            messageBrokerInputPort.insertReg(table, (Map<String, Object>) payload.get("after"));
        } else if ( operation.equals("d") ) {
            messageBrokerInputPort.deleteReg(table, (Map<String, Object>) payload.get("before"));
        } 
    }
    
}
