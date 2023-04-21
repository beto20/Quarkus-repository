package com.alberto.app.account.pub;

import com.alberto.app.account.model.dto.AccountDto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountAuditPublisher {
    @ConfigProperty(name = "connection-string.azure.service.bus", defaultValue = "<<CONNECTION_STRING>>")
    String connectionString;
    @ConfigProperty(name = "topic-name.azure.service.bus", defaultValue = "demo")
    String topicName;

    public void publish(AccountDto accountDto) throws JsonProcessingException {
//        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
//                .connectionString(connectionString)
//                .sender()
//                .topicName(topicName)
//                .buildClient();
//
//        String message = convertToJSONString(accountDto);
//        senderClient.sendMessage(new ServiceBusMessage(message));
    }

    public static String convertToJSONString(Object object) throws JsonProcessingException {
        ObjectMapper mapper = getObjectMapper();
        return mapper.writeValueAsString(object);
    }
    public static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
