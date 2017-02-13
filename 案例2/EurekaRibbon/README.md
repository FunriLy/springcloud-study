### 服务消费方+Ribbon实现负载均衡 EurekaRibbon

SpringBoot 版本 : 1.4.1.RELEASE

#### 添加依赖
```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-ribbon</artifactId>
		</dependency>
```

#### application.properties 配置:
```xml
# eureka client 配置
spring.application.name=ribbon-consumer
server.port=2222
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
```

#### 备注
`LoadBalancerClient`，这个是由 Netflix Ribbon 提供的工具类 。他会根据 ServiceId （配置文件中的Service Name）向 Eureka （注册服务器）获取服务地址。