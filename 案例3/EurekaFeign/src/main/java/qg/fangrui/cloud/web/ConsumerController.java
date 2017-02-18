package qg.fangrui.cloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qg.fangrui.cloud.service.ServiceClient;


/**
 * 调用服务
 * Created by zggdczfr on 2017/2/18.
 */
@RestController
public class ConsumerController {

    @Autowired
    private ServiceClient serviceClient;

    @RequestMapping("/test")
    public String test(){
        return serviceClient.printf();
    }
}
