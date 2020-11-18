# springboot-zuul
极简springboot+zuul入门案例
@[TOC](基于SpringBoot的zuul入门示例（极简！！！）)

# 环境

> windows 10
JDK 8
Idea  2017.3 ULTIMATE版
springboot  2.1.0.RELEASE版
zuul 2.1.0.RELEASE版

这里演示一下入门级的zuul网关的搭建，项目环境基于springboot。
* 首先搭建一个springboot**项目A**并发布一个REST接口

![直接访问项目A的REST服务](https://img-blog.csdnimg.cn/20201117213604482.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)
* 然后再基于springboot搭建一个zuul**项目B**，最后通过B来访问A中的REST接口。
![通过网关访问项目A的REST服务](https://img-blog.csdnimg.cn/20201117214109627.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)
# 搭建项目A
为了方便我们把项目A和项目B以Module的形式放在一个Project中。
首先建立一个空的文件夹springboot-zuul，然后在Idea中通过菜单 File -> Open..打开这个文件夹

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118224826259.jpg#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118224840639.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118225009389.jpg#pic_center)
接下来设置JDK和编译环境
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118225159539.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118225159566.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)
然后设置MAVN![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118225245814.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118225311136.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)
现在工程环境准备妥当了，开始创建**项目A** 菜单路径： File -> New -> Module...

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118225504478.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)
选择spring initializr

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020111721543593.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118225638989.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/202011182256394.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118225638912.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)
新建Controller类来发布服务

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118230424149.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x1b211aGU=,size_16,color_FFFFFF,t_70#pic_center)







```java
 @RestController
 @RequestMapping("/demo")
public class HelloController {

  @RequestMapping("/hello")
  public String sayHello(@RequestParam(required = false) String name){
    return "Hello " + name;
  }

}
```
启动项目后通过浏览器访问该服务
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201117215758887.jpg#pic_center)
# 搭建项目B（ZUUL网关服务）
新建springboot项目的过程同上，创建名为zuul的module，然后修改pom.xml添加zuul依赖：

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-zuul</artifactId>
			<version>2.1.0.RELEASE</version>
		</dependency>
<font color=#FF0000>同时记得把springboot的版本也改成和zuul一样！</font>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.0.RELEASE</version>
	</parent>
启动类添加zuul注解 
> @EnableZuulProxy

```java
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

}
```



接下来修改application.properties
```
# 应用名
spring.application.name=zuul
# 端口号
server.port=9090
# 配置映射路径
zuul.routes.zuul-provider.path=/service/**
zuul.routes.zuul-provider.url=http://127.0.0.1:8080/demo/hello/
```
接下来启动服务并通过浏览器访问http://127.0.0.1:9090/zuul/service?name=xiaoming进行验证吧
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201117221031142.jpg#pic_center)
这里可以看到通过网关成功的访问了项目A的服务，这个网关项目中没有写一行代码，只是引入了zuul的依赖并且配置了映射路径（实际应用中会更复杂，一般不会写死转发的url而是转到eruaka注册中心提供的服务上去）

接下来我们来体验一下通过ZuulFilter对请求进行过滤的操作，实际业务场景中经常用来做鉴权、日志记录等等，这里我们来模拟token鉴权。

首先新建TokenFilter类并继承ZuulFilter

```java
@Component
public class TokenFilter extends ZuulFilter{
    @Override
    public Object run() throws ZuulException {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        String token = request.getParameter("token");
        if(token == null) {
            //如果token为null则结束请求，不再继续传递下去
            rc.setSendZuulResponse(false);
            rc.setResponseStatusCode(401);
            rc.setResponseBody("{\"result\":\"token is null\"}");
            rc.getResponse().setContentType("text/html;charset=utf-8");
        }else {
        	//假如token未超时且成功解析出里面的键值对name=xiaoming
        	//把解析出的键值对放入请求参数中
            Map<String, List<String>> mq = rc.getRequestQueryParams();
            if(mq == null){mq = new HashMap<>(32);}
            mq.put("name", Collections.singletonList("xiaoming"));
            rc.setRequestQueryParams(mq);
        }
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 0;
    }
}

```
启动服务验证几个场景：
* 1、没有传入token时请求被拦截
* 2、传入token并且解析出token中的参数并且传给后端服务器（项目A）
### 1、拦截没有token的请求
浏览器中访问**项目B**的服务，不传入token
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118232103850.jpg#pic_center)
可以看到请求被拦击，没有抵达**项目A**
### 2、解析传入token中的参数并且传入后端
浏览器中访问**项目B**的服务，传入token（胡乱输入一些字符）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201118232150656.jpg#pic_center)
可以看到请求抵达**项目A**并且将token中解析出的参数传递给了后端。

以上就是我们演示的一个极简的基于SpringBoot的zuul网关示例了，演示的project已放入GitHub
