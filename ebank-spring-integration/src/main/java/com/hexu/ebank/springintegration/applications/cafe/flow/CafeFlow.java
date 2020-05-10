package com.hexu.ebank.springintegration.applications.cafe.flow;

import com.hexu.ebank.springintegration.applications.cafe.entity.Delivery;
import com.hexu.ebank.springintegration.applications.cafe.entity.Drink;
import com.hexu.ebank.springintegration.applications.cafe.entity.Order;
import com.hexu.ebank.springintegration.applications.cafe.entity.OrderItem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.stream.CharacterStreamWritingMessageHandler;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Configuration
@EnableIntegration
public class CafeFlow {

    private AtomicInteger hotDrinkCounter = new AtomicInteger();

    private AtomicInteger coldDrinkCounter = new AtomicInteger();

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedDelay(1000).get();
    }

    @Bean
    public IntegrationFlow orders() {
        return f -> f
                .split(Order.class, Order::getItems)
                .channel(c -> c.executor(Executors.newCachedThreadPool()))
                .<OrderItem, Boolean>route(OrderItem::isIced, mapping -> mapping
                        .subFlowMapping(true, sf -> sf
                                .channel(c -> c.queue(10))
                                .publishSubscribeChannel(c -> c
                                        .subscribe(s -> s.handle(m -> sleepUninterruptibly(1, TimeUnit.SECONDS)))
                                        .subscribe(sub -> sub
                                                .<OrderItem, String>transform(p ->
                                                        Thread.currentThread().getName() +
                                                                " prepared cold drink #" +
                                                                this.coldDrinkCounter.incrementAndGet() +
                                                                " for order #" + p.getOrderNumber() + ": " + p)
                                                .handle(m -> System.out.println(m.getPayload()))))
                                .bridge())
                        .subFlowMapping(false, sf -> sf
                                .channel(c -> c.queue(10))
                                .publishSubscribeChannel(c -> c
                                        .subscribe(s -> s.handle(m -> sleepUninterruptibly(5, TimeUnit.SECONDS)))
                                        .subscribe(sub -> sub
                                                .<OrderItem, String>transform(p ->
                                                        Thread.currentThread().getName() +
                                                                " prepared hot drink #" +
                                                                this.hotDrinkCounter.incrementAndGet() +
                                                                " for order #" + p.getOrderNumber() + ": " + p)
                                                .handle(m -> System.out.println(m.getPayload()))))
                                .bridge()))
                .<OrderItem, Drink>transform(orderItem ->
                        new Drink(orderItem.getOrderNumber(),
                                orderItem.getDrinkType(),
                                orderItem.isIced(),
                                orderItem.getShots()))
                .aggregate(aggregator -> aggregator
                        .outputProcessor(g ->
                                new Delivery(g.getMessages()
                                        .stream()
                                        .map(message -> (Drink) message.getPayload())
                                        .collect(Collectors.toList())))
                        .correlationStrategy(m -> ((Drink) m.getPayload()).getOrderNumber()))
                .handle(CharacterStreamWritingMessageHandler.stdout());
    }

    private static void sleepUninterruptibly(long sleepFor, TimeUnit unit) {
        boolean interrupted = false;
        try {
            unit.sleep(sleepFor);
        }
        catch (InterruptedException e) {
            interrupted = true;
        }
        finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
