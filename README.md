# 神算子项目（BDG接入ETHINK）
## 开发时间：2018-07
## 开发须知
### 简介
```
此项目是基于spring-cloud的restful项目，开发时按照严格的GET,POST,PUT,DELET进行注解,
路径可用资源形式表示
```
### 启动顺序
```
1 ssz-eureka-server
2 ssz-web-user(应用程序及相关联的应用程序（相关联的应用程序应该先启动）)
```
### 模块说明
```
- ssz-common:公共的工具类等
- ssz-common-redis:redis配置，需要使用redis的应用可引入到pom，配置yml后使用
- ssz-common-service: 配置了公用的service实体公共类,单独拎出来，是因为里面含有mongo配置，
                    其它不使用mongo的模块引入后，启动会报mongo错误
- ssz-eureka-server: 服务发现
- ssz-service-api: service接口
- ssz-web-mq: rabbitmq(待完善):主要用于消息发送
- ssz-web-XXX： 应用模块
```
### 不同模块调用接口使用FeignClient
```
例：A调用B的接口
- B的操作步骤：
1）定义一个纯粹的service接口（此接口不能继承其它接口，否则会报错），并在方法上添加请求路径
2）定义一个impl类，实现接口，并标注@RestController
- A的操作步骤：
1）pom.xml中引入spring-cloud-starter-feign
2）Application.java中增加注解@EnableFeignClients
3）新建service接口继承B的接口
4）在代码中注入新接口进行业务编写
详细demo见ssz-web-mq
```
### 开发注意事项
```
- 多模块之间尽量独立成模块，减少耦合，必要时可单独添加模块专门进行feignclient调用
- 开发时注意swagger的编写规则，可参考[swagger2基本语法](https://blog.csdn.net/u014231523/article/details/76522486)
```
### 方式打包
```
1）单个模块打包
根路径下执行下列命令：
mvn clean install
mvn package -pl ssz-web-user -am
```


### 关于项目 .iml 提交问题
本地执行下面的命令即可
git rm --cached *.iml
git commit -m "删除.iml缓存"