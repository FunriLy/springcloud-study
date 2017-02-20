package qg.fangrui.cloud.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zggdczfr on 2017/2/13.
 * 服务提供方提供的服务
 */
@RestController
public class PrintfController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/service")
    public String printf(){
        System.out.println("服务消费者正在使用服务，端口号为 : "+port);
        return "success";
    }
}
