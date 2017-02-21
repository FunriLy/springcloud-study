### 配置中心 Config Server

SpringBoot 版本 : 1.4.1.RELEASE
这里主要将以前的"服务注册中心"(Eureka Server)进行改造。

#### 主要依赖
```xml
        <!-- Config Server -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
```

#### application.properties 配置(主要是Config Server的配置):
```xml
server.port=8761
spring.cloud.config.server.git.uri=https://github.com/FunriLy/springcloud-study/
spring.cloud.config.server.git.searchPaths=config-repo
spring.cloud.config.server.git.username=Username
spring.cloud.config.server.git.password=Password
```

### Config Client
 
 这里主要是将以前的"服务提供者"(Eureka Client)进行改造。

#### bootstrap.properties 配置(注意这里是 bootstrap ):
 ```xml
spring.application.name=config-client
spring.cloud.config.profile=default
spring.cloud.config.label=master
spring.cloud.config.uri=http://localhost:8761/
```

### Config Client (续:实现配置文件刷新)
* 引入依赖
```xml
		<!-- actuator 监控 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
```

* 在 Controller层加入注解`@RefreshScope`

* 通过POST请求发送到 http://localhost:1111/refresh 

* 重新访问API接口 http://localhost:1111/config 来获取配置信息


### URL与配置文件的映射关系

*   /{application}/{profile}[/{label}]
*   /{application}-{profile}.yml
*   /{label}/{application}-{profile}.yml
*   /{application}-{profile}.properties
*   /{label}/{application}-{profile}.properties

application是`SpringApplication`的`spring.config.name`，(一般来说'application'是一个常规的Spring Boot应用)，profile是一个active的profile(或者逗号分隔的属性列表)，label是一个可选的git标签(默认为"master")。
比如，我的文件名是"config-client"，一般在Github上都是default环境，默认为master分支。所以就是`/config-client/default/master`
