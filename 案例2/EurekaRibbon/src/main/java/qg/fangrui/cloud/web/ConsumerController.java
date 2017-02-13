package qg.fangrui.cloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


/**
 * Created by zggdczfr on 2017/2/13.
 */
@RestController
public class ConsumerController {

    @Autowired
    private LoadBalancerClient client;

    @RequestMapping("/test")
    public String test(){
        ServiceInstance instance = client.choose("service");
        URI uri = instance.getUri();
        System.out.println(uri);
        return (new RestTemplate()).getForObject(uri+"/service",String.class);
    }
}
