package com.hexu.ebank.springintegration.config;


import com.hexu.ebank.springintegration.entity.Drink;
import com.hexu.ebank.springintegration.entity.Order;
import com.hexu.ebank.springintegration.entity.OrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class CafeConfig {

    private static final Logger logger = LoggerFactory.getLogger(CafeConfig.class);

    @Bean
    public MessageChannel receiverChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel replyChannel(){
        return new DirectChannel();
    }


    @Splitter(inputChannel="cafe.order.gateway.channel", outputChannel="drinks")
    public List<OrderItem> split(Order order) {

        return order.getItems();
    }

    @Router(inputChannel="drinks")
    public String resolveOrderItemChannel(OrderItem orderItem) {
        return (orderItem.isIced()) ? "coldDrinks" : "hotDrinks";
    }





    private long hotDrinkDelay = 5000;

    private long coldDrinkDelay = 1000;

    private final AtomicInteger hotDrinkCounter = new AtomicInteger();

    private final AtomicInteger coldDrinkCounter = new AtomicInteger();

    public void setHotDrinkDelay(long hotDrinkDelay) {
        this.hotDrinkDelay = hotDrinkDelay;
    }

    public void setColdDrinkDelay(long coldDrinkDelay) {
        this.coldDrinkDelay = coldDrinkDelay;
    }


    @Bean
    @ServiceActivator(inputChannel="hotDrinkBarista", outputChannel="preparedDrinks")
    public Drink prepareHotDrink(OrderItem orderItem) {
        try {
            Thread.sleep(this.hotDrinkDelay);
            logger.info(Thread.currentThread().getName()
                    + " prepared hot drink #" + hotDrinkCounter.incrementAndGet() + " for order #"
                    + orderItem.getOrderNumber() + ": " + orderItem);
            return new Drink(orderItem.getOrderNumber(), orderItem.getDrinkType(), orderItem.isIced(),
                    orderItem.getShots());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Bean
    @ServiceActivator(inputChannel="coldDrinkBarista", outputChannel="preparedDrinks")
    public Drink prepareColdDrink(OrderItem orderItem) {
        try {
            Thread.sleep(this.coldDrinkDelay);
            logger.info(Thread.currentThread().getName()
                    + " prepared cold drink #" + coldDrinkCounter.incrementAndGet() + " for order #"
                    + orderItem.getOrderNumber() + ": " + orderItem);
            return new Drink(orderItem.getOrderNumber(), orderItem.getDrinkType(), orderItem.isIced(),
                    orderItem.getShots());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }




}
