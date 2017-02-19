### 断路器 Hystrix

SpringBoot 版本 : 1.4.1.RELEASE
SpringCloud 版本 : Brixton.SR5

#### Hystrix Dashboard 主要依赖
```xml
		<!-- Hystrix Dashboard 监控 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
		</dependency>
```


#### application.properties 配置:
将 Hystrix 超时时间设置为1毫秒(为了看到回调效果)
```xml
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=1
```

#### 注解
`@FeignClient`中的`fallback` : 指定回调类。

`@EnableFeignClients` : 开启 Fegin 功能（包括 Hystrix ）。

`@EnableHystrixDashboard` : 开启 Hystrix Dashboard 监控视图。
