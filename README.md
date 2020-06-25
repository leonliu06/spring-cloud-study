## 1 服务的注册与发现 `consul`
- 设有B服务，其名称为`service-b`，A服务，其名称为`servcie-a`，要使B可以通过A服务的**名称service-a**来调用A的接口，则需要B和A都互相认识，即知道彼此的名称，
这就需要一个共享的存在，这个存在就是**服务注册与发现**组件。这类组件有`Eureka` 和 `consul`等。
- 如果没有服务注册与发现组件，则通过**名称**调用接口时，会报`java.net.UnknownHostException`异常。
- 只能通过`IP+端口`调用才能正常，所以从这个角度说，服务注册与发现组件也体现了类似`DNS`的作用。
- 如何将服务注册到 `consul` 中，参看服务 `consul-demo-producer` 和 `consul-demo-consumer` 的依赖配置。

## 2 服务消费者 `service-b`
&emsp;&emsp;服务消费者 `service-b` 通过 `RestTemplate + Ribbon` 方式来调用服务生产者 `service-a` 的 `rest` 接口。

## 3 服务消费者 `service-c`
&emsp;&emsp;服务消费者 `service-c` 通过 `Feign` 方式来调用服务生产者 `service-a` 的 `rest` 接口。

## 4 断路器（circuit breaker）`Hystrix`
- 在微服务中，由于网络原因或自身原因，服务并不能保证100%可用，如果单个服务出现问题，比如 `service-a` 出现问题， `service-b` 在调用 `service-a` 时就会出现线程阻塞，此时若 `service-b` 有大量请求调用，则 `service-b` 的 `Servlet` 容器的线程资源会被消耗完毕，导致服务瘫痪。
- 服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的后果，这就是服务故障的“雪崩”效应。
- 为了解决这个“雪崩”问题，就出现了**断路器（circuit breaker）**模型。
- Spring Cloud 中的断路器是 `Hystrix` ，即 `spring-cloud-starter--netflix-hystrix` 依赖。

### 4.1 在 `service-b` 的 `RestTemplate + Ribbon` 调用外部服务方式中使用 `Hystrix`
&emsp;&emsp;具体看服务消费者 `service-b`
### 4.2 在 `service-c` 的 `Fiegn` 调用外部服务方式中使用 `Hystrix`
&emsp;&emsp;具体看服务消费者 `service-c`

## 5 微服务网关`zuul`
&emsp;&emsp;微服务架构中，为了避免客户端与多个微服务之间的请求复杂性，需要一个介于客户端和各个微服务器端之间的中间层，这个中间层就是**微服务网关**。Spring Cloud体系中用到的微服务网关是 `Zuul`。微服务网关的主要功能是**路由转发**和**过滤器**。  

1. 路由转发：默认情况下，`Zuul`会代理所有注册到注册中心如`consul`或`Eureka`上的微服务，且 `Zuul` 的路由规则如下：`http://ZUUL_HOST:ZULL_PORT/serviceId/**` 会被转发到 `serviceId` 对应的微服务。其中 `serviceId` 指的是微服务注册在注册中心上的 `serviceId` 。
    1. 可以进行多种方式的路由配置，如配置需要忽略的服务，配置同时指定微服务的 `serviceId` 和对应路径等
    2. 可将 `com.netflix` 包的日志级别设为`DEBUG`，这样可以打印路由转发的具体细节，有助于理解 `Zuul` 的路由配置，如 `logging: level: com.netfilx: DEBUG` 。
2. 过滤器：编写过滤器只需继承抽象类 `ZuulFilter` ，然后实现几个抽象方法就可以了。  

&emsp;&emsp;微服务网关服务工程参看`service-gateway-zuul` 。


## 6 分布式配置中心组件 `spring cloud config`

## 7 高可用的分布式配置中心 `spring cloud config`
