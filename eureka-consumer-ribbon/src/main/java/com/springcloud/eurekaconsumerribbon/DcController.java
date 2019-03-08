package com.springcloud.eurekaconsumerribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wanrh@jurassic.com.cn
 * @date 2019/3/6 15:18
 */
@RestController
public class DcController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc(){

        return restTemplate.getForObject("http://eureka-client/dc",String.class);
    }


}
