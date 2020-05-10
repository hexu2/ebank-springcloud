package com.hexu.ebank.springintegration.config;

import com.hexu.ebank.springintegration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationConfig {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Bean
    public MessageChannel receiverChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel replyChannel(){
        return new DirectChannel();
    }

//
//    @Bean
//    @Transformer(inputChannel = "integration.tuser.gatewary.channel", outputChannel = "integration.tuser.toConvertObj.channel")
//    public HeaderEnricher enricherHeader(){
//
//        Map<String, HeaderValueMessageProcessor<String>> heardsToAdd = new HashMap<>();
//        heardsToAdd.put("header1",new StaticHeaderValueMessageProcessor<>("Test header1"));
//        heardsToAdd.put("header2",new StaticHeaderValueMessageProcessor<>("Test header2"));
//        HeaderEnricher headerEnricher = new HeaderEnricher(heardsToAdd);
//        return headerEnricher;
//    }
//
//
//    @Bean
//    @Transformer(inputChannel = "integration.tuser.toConvertObj.channel", outputChannel = "integration.tuser.objToJson.channel")
//    public ObjectToJsonTransformer ObjToJsonTransformer(){
//        logger.debug(" ObjToJsonTransformer ===========");
//        return new ObjectToJsonTransformer(getMapper());
//    }
//
//    @Bean
//    public Jackson2JsonObjectMapper getMapper(){
//        ObjectMapper objectMapper = new ObjectMapper();
//        logger.debug(" getMapper ===========");
//        return new Jackson2JsonObjectMapper(objectMapper);
//    }
//
//    @Bean
//    @Transformer(inputChannel = "integration.tuser.jsonToObj.channel", outputChannel = "integration.tuser.jsonToObj.fromTransformer.channel")
//    public JsonToObjectTransformer jsonToObjTransformer(){
//        logger.debug(" jsonToObjTransformer ===========");
//
//        return new JsonToObjectTransformer(TUser.class);
//
//    }
//
//
//
//
//
//
//
//    @Bean
//    @ServiceActivator(inputChannel = "repecipientList.router.channel")
//    public RecipientListRouter pecipientListRouter(){//Payload type router sample
//        RecipientListRouter recipientListRouter = new RecipientListRouter();
//        recipientListRouter.addRecipient("tuser.channel.1");
//        recipientListRouter.addRecipient("tuser.channel.2");
//        return recipientListRouter;
//    }
//
//
//    @Bean
//    @ServiceActivator(inputChannel = "payload.router.channel")
//    public PayloadTypeRouter payloadTypeRouter(){//Payload type router sample
//        PayloadTypeRouter payloadTypeRouter = new PayloadTypeRouter();
//        payloadTypeRouter.setChannelMapping(TUser.class.getName(), "tuser.from.payloadtyperouter.channel");
//        payloadTypeRouter.setChannelMapping(Address.class.getName(),"address.from.payloadtyperouter.channel");
//
//        return payloadTypeRouter;
//    }
//
//    @Bean
//    @Filter(inputChannel = "filter.router.channel")
//    public MessageFilter filter(){
//        MessageFilter messageFilter = new MessageFilter(new MessageSelector() {
//            @Override
//            public boolean accept(Message<?> message) {
//
//                if(message.getPayload() instanceof TUser){
//                    return true;
//                } else if (message.getPayload() instanceof Address){
//                    return true;
//                } else {
//                    return false;
//                }
//
//            }
//        });
//        messageFilter.setOutputChannelName("filter.result.channel");
//
//        return messageFilter;
//    }

}
