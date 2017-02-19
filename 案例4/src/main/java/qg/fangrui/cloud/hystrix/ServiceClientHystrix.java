package qg.fangrui.cloud.hystrix;

import org.springframework.stereotype.Component;
import qg.fangrui.cloud.service.ServiceClient;

/**
 * 断路器模式
 * Created by zggdczfr on 2017/2/19.
 */
@Component
public class ServiceClientHystrix implements ServiceClient {

    @Override
    public String printf() {
        return "断路器 : 回调函数";
    }
}
