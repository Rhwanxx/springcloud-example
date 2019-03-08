package com.springcloud.eurekaconsumerfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanrh@jurassic.com.cn
 * @date 2019/3/8 16:56
 */
@RestController
public class DcController {

    @Autowired
    DcClient client;

    @GetMapping("/consumer")
    public String dc(){
        return client.consumer();
    }

}
