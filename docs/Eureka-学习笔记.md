## 关于 Eureka 的学习笔记

### 前言
Eureka是Netflix开发的服务发现组件，本身是一个基于REST的服务。Spring Cloud将它集成在其子项目spring-cloud-netflix中，以实现Spring Cloud的服务发现功能。
在Spring Cloud中，将会使用 Eureka 作为发现服务，所以了解 Eureka 是非常重要的。因此做了一下翻译以及学习笔记记录。
Eureka的Github：[https://github.com/Netflix/Eureka](https://github.com/Netflix/Eureka)

### Eureka 笔记
#### 什么是 Eureka？
Eureka 是基于 REST(Representational State Transfer)服务。主要用于AWS云中的**_定位/发现服务_**，从而实现对于中间层服务器的负载均衡(Load Balance)和故障切换(failover)。
同时，Eureka 还提供了一个基于JAVA的客户端组件(Eurake Client)，**_便于与Eureka Server进行交互_**。在客户端中，同样内置了负载均衡，用于执行基本的负载均衡轮询制度。
而 Netflix 将它们集合成一个更加负载的负载均衡器，通过对流量、资源使用等因素，提供了更加合理的加权负载均衡策略服务。Eureka 具有心跳检测、健康检查和客户端缓存等多种机制提高了服务系统的灵活性。

#### 什么是AWS云？
对于AWS云，可以参考一下这篇博文 http://blog.csdn.net/awschina/article/details/17639191
感觉 Eureka 就是为了提供对于 AWS云服务 的补充(中间层负载均衡)。

#### 什么是中间层(Middle Tier)？
上面老是提到了中间层(Middle Tier)。中间层 (Middle Tier)也称作“应用程序服务器层或应用服务层”，是用户接口或 Web 客户端与数据库之间的逻辑层。典型情况下 Web 服务器位于该层，业务对象在此实例化。(**来源于百度百科**)

#### Eureka 目的/优点
* 中间层的负载均衡
* 使用 Netflix 的红/黑部署(red/black deployments)，使开发者更加容易实现云部署
* 对于 cassandra deployments，方便于对实例化后的对象维护
* 利用 memcached 提供缓存服务(_Memcached_ 是一个高性能的分布式内存对象缓存系统，用于动态Web应用以减轻数据库负载。)。
* 可配置性/动态配置。使用Eureka，可以即时添加或删除群集节点；Eureka使用archaius(Netflix开源的配置管理类):如果你有一个配置源实现，这些配置可以进行动态调整应用。

#### Eureka 最大的特性
Eureka 集群服务具有极大的"弹性"(_Resilience_)。这个是我认为它最大的特点。
* Eureka Client 处理一个或多个Eureka服务器的故障。 由于 Eureka Client 在其中具有注册表缓存信息，因此即使所有 Eureka Servers 都关闭，它们还是可以很好地运行。
* Eureka Servers 即使在其他 Eureka 挂了也具有极大的"弹性"。既是是在 Client 与 Server 的网络分裂(network partition)期间，Eureka Server 具有的内部弹性特性也能防止大规模服务中断。

#### Eureka Server 与 Client 之间的通信
Eureka 只是找到有关客户端与之通信的服务器的信息，但不对通信的协议或方法施加任何限制。通常情况下，我们可以使用 Eureka 获取目标服务器地址，并使用thrift，http(s)或任何其他RPC机制等协议来进行交互通信。

#### Eureka 架构
![](https://www.tuchuang001.com/images/2017/02/11/eureka.png)
接下来，对其中的名词进行解释：
* Application Service 相当于服务提供者
* Application Client 相当于服务消费者
* Make Remote Call，其实就是实现服务的使用
* us-east-1 其实实现了Eurake 集群服务
* us-east-1c、us-east-1d、us-east-1e 就是集群服务中的某个具体实现区域(感觉找不到一个合适的词来解释这种抽象的概念)

**Eureka 架构机制**
我们的 Eureka 集群服务其实就是靠 Server 与 Client 之间的交互来实现的。
1. 前面说过，Eureka Server 具有服务定位/发现的能力，在各个微服务启动时，会通过Eureka Client向Eureka Server进行注册自己的信息（例如网络信息）。
2. 一般情况下，微服务启动后，Eureka Client 会周期性向 Eureka Server 发送心跳检测(默认周期为30秒)以注册/更新自己的信息。
3. 如果 Eureka Server 在一定时间内(默认90秒)没有收到 Eureka Client 的心跳检测，就会注销掉该微服务点。
4. 同时，Eureka Server 它本身也是 Eureka Client，多个 Eureka Server 通过复制注册表的方法来完成服务注册表的同步从而达到集群的效果

### 参考资料  
* https://github.com/Netflix/eureka/wiki