## Spring Cloud Study

** 详情参考个人博客空间 https://zggdczfr.cn **


### spring boot 版本依赖
```xml
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.4.1.RELEASE</version>
		<relativePath/> 
	</parent>
```
Spring Boot 版本选定为 1.4.1.RELEASE，是为了更加方便与SpringBoot-Study结合起来。
注意 : 若 Spring Boot 版本为 1.5.X，启动时会抛出一个`java.lang.ClassNotFoundException: org.springframework.boot.context.embedded.`错误，具体解决方案参考 : http://snacktrace.com/artifacts/org.springframework.boot/spring-boot/1.1.11.RELEASE/org.springframework.boot.context.embedded.FilterRegistrationBean

### spring cloud 版本依赖
```xml
	<!-- 还是比较喜欢稳定的 Brixton 版本 -->
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>Brixton.RELEASE</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
```

### 案例目录
##### 案例1 : 服务注册与发现
##### 案例2 : 服务消费(Ribbon实现客户端负载均衡)
##### 案例3 : 服务消费(Feign实现客户端负载均衡)
##### 案例4 : 断路器 Hystrix
##### 案例5 : 配置中心 Config Server