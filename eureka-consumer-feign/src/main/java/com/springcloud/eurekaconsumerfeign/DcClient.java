package com.springcloud.eurekaconsumerfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wanrh@jurassic.com.cn
 * @date 2019/3/8 16:55
 */
@FeignClient("eureka-client")
public interface DcClient {

    @GetMapping("/dc")
    String consumer();
}
