package qg.fangrui.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 分布式配置中心
 * 服务注册中心
 */

@SpringBootApplication
@EnableEurekaServer
@EnableConfigServer
public class MySpringCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(MySpringCloudApplication.class, args);
	}
}