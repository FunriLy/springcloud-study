## 使用Ribbon实现客户端的负载均衡

** 个人博客空间 : https://zggdczfr.cn/ **

#### 依赖
```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-ribbon</artifactId>
		</dependency>
```

#### 备注
EurekaClient工程添加了一个提供的服务，EurekaService并无任何修改。