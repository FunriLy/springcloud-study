### 服务注册中心 EurekaServer

SpringBoot 版本 : 1.4.1.RELEASE

#### 主要依赖
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<!-- eureka-服务 -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka-server</artifactId>
			<version>1.2.5.RELEASE</version>
		</dependency>
```

#### application.properties 配置:
```xml
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.client.serviceUrl.defaultZone=http://localhost:${server.port}/eureka/
```
`eureka.client.registerWithEureka` ：表示是否将自己注册到Eureka Server，默认为true。由于当前这个应用就是Eureka Server，故而设为false。
`eureka.client.fetchRegistry` ：表示是否从Eureka Server获取注册信息，默认为true。因为这是一个单点的Eureka Server，不需要同步其他的Eureka Server节点的数据，故而设为false。
`eureka.client.serviceUrl.defaultZone` ：设置与Eureka Server交互的地址，查询服务和注册服务都需要依赖这个地址。默认是`http://localhost:8761/eureka` ；多个地址可使用 , 分隔。