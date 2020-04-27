package com.hexu.ebank.gate.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configurable
public class ClientFallbackProvider implements FallbackProvider {


    private static final Logger logger = LoggerFactory.getLogger(ClientFallbackProvider.class);
    private static final String classname = ClientFallbackProvider.class.getName();

    /**
     * 返回值表示需要针对此微服务进行回退处理(必须是在注册中心中的service-id).
     * Zuul目前只支持服务级别的熔断，对具体某个URL的熔断暂不支持
     * @return
     */
    @Override
    public String getRoute() {
//        return "eureka-client";  //服务Id ，若需要所有服务调用都支持回退，返回null 或者 * 即可
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * 客户端向网关发送服务成功，网关向api服务请求失败，不应该把api的404 500 等问题抛给客户端
             * 网关和api服务对客户端来说都是黑盒子。
             *
             * @return
             * @throws IOException
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
//                int value = HttpStatus.OK.value();
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
//                String getReasonPhrase =  HttpStatus.OK.getReasonPhrase();
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            /**
             * 微服务出现宕机后，客户端再次请求就会返回fallback中的预设值
             *
             * @return
             * @throws IOException
             */

            @Override
            public InputStream getBody() throws IOException {
                //服务异常时，输出此处内容，并打印错误日志
                logger.error("error appear ");
                return new ByteArrayInputStream("this service is ubable use".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        } ;
    }

}