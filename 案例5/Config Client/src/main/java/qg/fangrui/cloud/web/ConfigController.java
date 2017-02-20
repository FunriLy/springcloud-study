package qg.fangrui.cloud.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取 Config
 * Created by zggdczfr on 2017/2/20.
 */
@RestController
public class ConfigController {

    @Value("${configword}")
    String configword;

    @RequestMapping("/config")
    public String printfConfig(){
        return "The Config Word Is : "+configword;
    }
}
