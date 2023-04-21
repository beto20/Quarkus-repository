package com.alberto.core.audit.sub;

import com.alberto.core.audit.model.SubscriberMessageActions;
import com.alberto.core.audit.model.dto.AuditAccountDto;
import com.alberto.core.audit.service.AuditService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static java.nio.charset.StandardCharsets.UTF_8;

@ApplicationScoped
public class AccountAuditSubscriber {
    @ConfigProperty(name = "connection-string.azure.service.bus", defaultValue = "<<CONNECTION_STRING>>")
    String connectionString;
    @ConfigProperty(name = "topic-name.azure.service.bus", defaultValue = "demo")
    String topicName;
    @ConfigProperty(name = "topic-subcription.azure.service.bus", defaultValue = "demoSubs")
    String subName;

    @Inject
    AuditService auditService;

//    public SubscriberMessageActions receiveMessages() throws InterruptedException {
//        CountDownLatch countdownLatch = new CountDownLatch(1);
//
//        ServiceBusProcessorClient processorClient = new ServiceBusClientBuilder()
//                .connectionString(connectionString)
//                .processor()
//                .topicName(topicName)
//                .subscriptionName(subName)
//                .processMessage(context -> processMessage(context))
//                .processError(context -> processError(context, countdownLatch))
//                .buildProcessorClient();
//
//        System.out.println("Starting the processor");
//        processorClient.start();
//
//        TimeUnit.SECONDS.sleep(10);
//
//        System.out.println("Stopping and closing the processor");
//        processorClient.close();
//
//        return SubscriberMessageActions.COMPLETE;
//    }
//
//    private void processMessage(ServiceBusReceivedMessageContext context) {
//        ServiceBusReceivedMessage message = context.getMessage();
//        System.out.printf("[Subscriber] Processing message. Session: %s, Sequence #: %s. Contents: %s%n", message.getMessageId(), message.getSequenceNumber(), message.getBody());
//
//        String jsonMessage = new String(message.getBody().toBytes(), UTF_8);
//        var auditAccountDto = fromJson(jsonMessage, AuditAccountDto.class);
//        auditService.persistAuditAccount(auditAccountDto);
//    }
//
//    private static void processError(ServiceBusErrorContext context, CountDownLatch countdownLatch) {
//        System.out.printf("Error when receiving messages from namespace: '%s'. Entity: '%s'%n", context.getFullyQualifiedNamespace(), context.getEntityPath());
//
//        if (!(context.getException() instanceof ServiceBusException)) {
//            System.out.printf("Non-ServiceBusException occurred: %s%n", context.getException());
//            return;
//        }
//
//        ServiceBusException exception = (ServiceBusException) context.getException();
//        ServiceBusFailureReason reason = exception.getReason();
//
//        if (reason == ServiceBusFailureReason.MESSAGING_ENTITY_DISABLED || reason == ServiceBusFailureReason.MESSAGING_ENTITY_NOT_FOUND || reason == ServiceBusFailureReason.UNAUTHORIZED) {
//            System.out.printf("An unrecoverable error occurred. Stopping processing with reason %s: %s%n", reason, exception.getMessage());
//            countdownLatch.countDown();
//        } else if (reason == ServiceBusFailureReason.MESSAGE_LOCK_LOST) {
//            System.out.printf("Message lock lost for message: %s%n", context.getException());
//        } else if (reason == ServiceBusFailureReason.SERVICE_BUSY) {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                System.err.println("Unable to sleep for period of time");
//            }
//        } else {
//            System.out.printf("Error source %s, reason %s, message: %s%n", context.getErrorSource(), reason, context.getException());
//        }
//    }

    public static <T> T fromJson(String message, Class<T> clazz) {
        ObjectMapper objectMapper = getObjectMapper();
        try {
            return objectMapper.readValue(message, clazz);
        } catch (IOException var4) {
            throw new RuntimeException(var4.getMessage(), null);
        }
    }

    public static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
