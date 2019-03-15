package com.springcloud.eurekaconsumerribbonhystrix;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author wanrh@jurassic.com.cn
 * @date 2019/3/11 11:31
 */
@RestController
public class DcController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String dc(){
        return consumerService.consumer();
    }

    @Component
    class ConsumerService {

        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer(){
            ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
            String url = "http://"+ serviceInstance.getHost()+"/dc";
            return restTemplate.getForObject(url,String.class);
        }

        public String fallback(){
            return "fallback";
        }
    }
}
