package com.springcloud.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanrh@jurassic.com.cn
 * @date 2019/2/25 11:41
 */
@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("dc")
    public String dc(){
        String services = "Services" + discoveryClient.getServices();
        System.out.println("这是来自client1的信息："+services);
        return services;
    }
}
