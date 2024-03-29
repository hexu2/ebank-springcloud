package com.hexu.ebank.springintegration.applications.filecopy;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.File;
import java.util.Scanner;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class FileCopyIntegration {

    public final String INPUT_DIR = "/tmp/source";

    public final String OUTPUT_DIR = "/tmp/target";


    public final String FILE_PATTERN = "*.txt";

    @Bean
    public MessageChannel fileChannel(){
        return new DirectChannel();

    }

    @Bean
    @InboundChannelAdapter(value = "fileChannel", poller = @Poller(fixedRate = "5000"))
    public MessageSource<File> fileReadingMessageSource(){

        FileReadingMessageSource sourceReader = new FileReadingMessageSource();

        sourceReader.setDirectory(new File(INPUT_DIR));
        sourceReader.setFilter(new SimplePatternFileListFilter(FILE_PATTERN));

        System.out.println("Message count = " + sourceReader.messageCount());

        sourceReader.start();
        return sourceReader;
    }


    @Bean
    @ServiceActivator(inputChannel = "fileChannel")
    public MessageHandler fileWritingMessageHandler(){
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(OUTPUT_DIR));

        handler.setFileExistsMode(FileExistsMode.REPLACE);
        handler.setExpectReply(false);
        return handler;
    }

    public static void main(String[] args) {
        final AbstractApplicationContext context = new AnnotationConfigApplicationContext(FileCopyIntegration.class);

        context.registerShutdownHook();
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a String and press <enter> :");

        while(true){

            final String input = scanner.nextLine();
            if("q".equalsIgnoreCase(input)){
                context.close();
                scanner.close();
                break;
            }
        }

        System.exit(0);

    }

}
