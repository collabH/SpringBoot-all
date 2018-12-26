
# SpringBoot-all
SpringBoot详细 原理加应用
### course1  课程一 SpringBoot快速入门
    https://start.spring.io/ Springboot项目快速构建网站
    
    @SpringBootApplication注解
    查看源码发现它相当于SpringBootConfiguration Springboot配置类似于Configuration注解
    EnableAutoConfiguration 自动注入配置
    ComponentScan 扫描 这三个注解
    
### course2 课程2  SpringBoot配置分析    
    默认配置文件application.properties默认的位置在classpath根目录，或者是classpath/config目录下
    file:/，file:config/
               也可以使用yaml格式,application.yml或者application.yaml
    application中是自定义参数，在Courese2Application用三种方式取得配置文件中的值
    1.@Value  Spring注解 默认值方式为${"hello:huangsm"}
    2.Environment   SpringBoot新特性，通过键值对的方式获取配置值      
    3.通过@ConfigurationProperties(prefix = "huel") 代码参考Huel实体类
    
    TomcatProperties支持集合和数组的注入
    
    2.动态的引入配置文件
     自定义MyEnvironmentPostProcessor实现EnvironmentPostProcessor接口
     
    3.各个生产环境的切换---通过配置方式
    #测试环境
    spring.profiles.active=dev
    
    maven启动参数方式切换配置文件(表示启用多个)
    --spring.profiles.active=dev,prod

    4.根据不同环境注入不同的Bean 
    详情查看MyConfig编码
    @Profile注解在类上或者方法上使用，代表装配不同的Bean
     
    
###  course3 课程3  SpringBoot自动配置

    1.Condition接口   (用来自定义条件装配来使用)
    其中有一个抽象方法matches，参数分别为ConditionContext context, AnnotatedTypeMetadata metadata
    如何这个方法返回true表示可以自动装配，false表示不装配
    2.Conditional注解 对接口的注解封装
    基于条件的自动装配，一般配合Condition接口一起使用，只有接口实现类返回true，才装配，否则不装配，
    他可以用在方法上，也可以用在类上。    
    3. @ConditionalOnProperty(name="runable.enabled",havingValue = "true")
    读取配置文件中的runable.enabled，为true该Bean装配，否则不装配
    4. @ConditionalOnClass(name = "com.google.gson.Gson")
    表示类路径下存在Gson这个包的时候才装配
    5.@ConditionalOnBean(name = "user")
    根据容器中是否存在某个bean来进行装配
    6.ConditionalOnMissingBean(name="user")
    当容器中不存在bean时才装配

###  course4 课程4  Spring Boot @Enable*注解的工作原理
    1.@EnableConfigurationProperties注解
    用来启用一个特性的，这个特性就是，可以把配置文件的属性注入到bean里面去，和@ConfigurationProperties一起使用
    
    2.@EnableAsync启用异步，一般适合@Async一起使用
    
    3.@Enable的工作原理在于引入一个或者多个配置
    @Enable中做重要的注解在于@import将Bean装配导入到spring容器，@Enable内部就是导入一个配置类
    
    4.@import用来导入一个或者多个类(bean会被Spring容器所托管)或者配置类(配置类中的bean都会被spring容器所托管)
    
    5.ImportSelector
    其中有一个selectImports方法，方法的返回值必须是一个class(全称),该class会被spring容器所托管起来
    
    6.ImportBeanDefinitionRegistrar
    通过实现这个接口的registerBeanDefinitions方法，调用一下代码:
     BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(User.class);
     registry.registerBeanDefinition("user", beanDefinitionBuilder.getBeanDefinition());
     
###  course5 课程5 Spring Boot @EnableAutoConfiguration深入分析(无代码偏理论和源码分析，可以仔细研究这个注解的源码)
    1.@EnableAutoConfigurationchong
    作用:从classpath中搜索所以META-INF/spring.factories配置文件，然后将其中
    org.springframework.boot.autoconfigure.EnableAutoConfiguration key对应的配置项加载到spring容器中
    
    只有org.springframework.boot.autoconfigure.EnableAutoConfiguration为true时才会生效，默认为true
    @EnableAutoConfiguratio还可以进行排除:排除方式有俩种:1.通过class来排除
                                                       2.根据类的名字来排除
    
    
    2.其内部实现的关键点
    ImportSelector 该接口的方法返回值都会被纳入到Spring容器管理中
    SpringFactoriesLoader 该类可以从classpath中搜索所以META-INF/spring.factories配置文件，并读取配置
  
### course6 课程6 Spring Boot 事件监听 --四种方式讲解如何配置事件监听  (代码也放在course5中)
**事件流程**
1. 自定义事件，一般是继承ApplicationEvent抽象类
2. 定义事件监听器，一般是实现ApplicationListener接口   
3. 启动事件，需要把监听器加入到spring容器中   
             
 		 1.添加事件监听器app.addApplicationListener(new MyApplicationListener());
         2.使用@Component将事件监听器加入到spring容器中
         3.通过全局配置的方式context.listener.classes=com.springboot.study.course5.listener.MyApplicationListener
         4.自定义事件处理器，类似于代码中的MyEventHandle

4. 发布事件     app.publishEvent(new MyApplicationEvent(new Object()));

**源码分析**
1. DelegatingApplicationListener，查看这个类，阅读源码，配置方式的源码
2. EventListenerMethodProcessor，事件处理器方式源码，其核心实现根据@EventListener来处理监听事件

### course7 课程7 Spring Boot 扩展分析ApplicationContextInitializer、CommandLineRunner、ApplicationRunner、ApplicationArguments
1.ApplicationContextInitializer 接口是在Spring容器执行refreshed之前的一个回调
**使用步骤:**
1. 写一个类，实现ApplicationContextInitializer接口
2. 注册ApplicationContextInitializer

**注册方法:**
1. ApplicationContextInitializer.addInitializers
2. 通过配置文件配置:context.initializer.classes指定,需要指定多个请看course7代码配置文件
3. 通过METE/INF中的spring.factorties文件中指定(也可以注册监听器)

2. CommandLineRunner是Spring容器启动成功后的最后一步回调 (步骤参考ServerSuccessReport代码)
**使用步骤**
1. 写一个类实现CommandLineRunner接口
2. 通过@Component将它交给容器管理

通过@Order(param)来控制多个CommandLineRunner实现类的执行顺序，param参数数字最大，最早执行。
3. CommandLineRunner，ApplicationRunner区别:
  

      区别在于方法的参数不一样
        CommandLineRunner的参数是最原始的参数，没有做任何处理
        ApplicationRunner的参数是ApplicationArguments 是对原始参数进一步的封装

4. ApplicationArguments是对参数(main方法)进一步处理，可以解析--name=value的，我们可以通过name来获取value
        
### course8 课程8 Spring Boot 补充讲解
**@SpringBootApplication**        
        
       默认扫描当前类已经子类下的所有包
      1.@SpringBootApplication(exclude = ServerSuccessReport.class)
      不扫描ServerSuccessReport这个类
      2.@SpringBootApplication(excludeName = "com.springboot.study.course7.MyApplicationContextInitializer")
      不扫描MyApplicationContextInitializer这个类
      3.@SpringBootApplication(scanBasePackages = "com.springboot.study.course7")
      扫描com.springboot.study.course7下的所有类
      4.@SpringBootApplication(scanBasePackageClasses = MyApplicationContextInitializer.class)
      扫描这个类
**banner**
1. 在resources添加自己的banner.txt替换系统的banner
2. 也可以关闭banner
3. 支持图片格式banner，支持jpg，png，gif
4. 修改全局配置文件     
    banner.location=my.txt
    banner.charset=GBK
    banner.image.location=my.jpg
### course9 课程9 Spring Boot 运行流程分析      
1. 俩种方法创建SpringBoot启动类
    `第一种调用方式:
    SpringApplication app=new SpringApplication(Course7Application.class);
    app.run(args);
    第二种调用方式:
    SpringApplication.run(Course7Application.class, args);`
2. 运行流程
    1. 判断是不是Web环境
     2. 加载所有classpath下面的META-INF/spring.factorties ApplicationContextInitializer
     3. 加载所有classpath下面的META-INF/spring.factorties ApplicationListener
     4. 推断main方法所在的类
     5. 开始执行run方法
     6. 设置java.awt.headless系统变量
     7. 加载所有classpath下面的META-INF/spring.factorties SpringApplicationRunnerListener
     8. 执行所有SpringApplicationRunnerListener的started方法
     9. 实例化ApplicationArguments对象
     10. 创建environment
     11. 配置environment，主要是把run方法的参数配置到environment中
     12. 执行所有SpringApplicationRunnerListener的environmentPrepared方法
     13. 如果不是web环境，但是是web的environment，则把这个web的environment转换长标准的environment
     14. 打印banner
     15. 初始化applicationContext，如果是web环境，则实例化AnnotationConfigEmbeddedWebApplicationContext对象，否则实例化AnnotationConfigApplicationContext对象
     16. 如果beanNameGenerator不为空，就把beanNameGenerator对象注入到applicationContext里面去
     17. 回调所有的ApplicationContextInitializer方法
     18. 执行所有SpringApplicationRunnerListener的contextPrepared方法
     19. 依次往spring容器中注入:ApplicationArguments,Banner
     20. 加载所有的源到applicationContext里面去
     21. 执行所有SpringApplicationRunnerListener的contextLoaded方法
     22. 执行applicationContext的refresh方法，并且调用applicationContext的registerShutdownHook方法
     23. 回调，获取容器中所有的ApplicationRunner，CommandLineRunner接口，然后排序，依次调用
     24. 执行所有SpringApplicationRunnerListener的finished方法
    
### course10 课程10 Spring Boot Web开发    
1. 快速开发一个接口(参照代码)
2. 修改默认端口号 修改配置文件server.port=8181
3. @RequestParam默认参数必须提供，修改required可以不用提供值 @RequestParam(value = "name",required = false,defaultValue = "huangsm")
4. @PathVariable获得路径中的值，参考代码
5. @RestController返回Json格式给前台
6. 整合JSP引入依赖tomcat-embed-jasper，配置spring.mvc.view.prefix=/WEB-INF/jsp/和spring.mvc.view.suffix=.jsp(详情参考JspController)
7. 整合freemarker，引入spring-boot-starter-freemarker，ftl页面放在templates中(详细看代码，和配置文件)
8. 配置访问默认前缀 server.servlet.context-path=/huangsm，默认为/
9. 更换web容器，首先在spring-boot-starter-web排序spring-boot-starter-tomcat的依赖，在添加spring-boot-starter-jetty的依赖(这里就不测试了)
10. SpringBoot访问静态资源，可以将静态资源放在src/main/webapp下，springboot中将它放入static中，可以通过freemarker访问(详细看代码)，也可以直接访问
    `#修改默认静态页面路径`
   ` spring.resources.static-locations=classpath:/META-INF/resources/,classpath:/resources/static/,classpath:/static/,classpath:/public`
11. 方式一:如何在SpringBoot中使用servlet,详细查看UserServlet类，需要使用@WebServlet("/user.do")表明路径，在启动类中开启对Servlet的扫描@ServletComponentScan
12. 如何在SpringBoot中使用Filter，实现Filter接口，编写自己的业务逻辑，通过@WebFilter注解添加过滤规则(详细参考LogFilter代码)
13. 如何在SpringBoot中使用Listener，实现ServletContextListener接口，实现他的俩个方法，通过@WebListener注解启动监听器
14. 方式二:用配置类来使用Servlet、Filter、Listener（使用详细查看servlet包下代码）
    `1.编写Servlet
     2.装配相应的bean到spring容器中
     servlet ->ServletRegistrationBean
     filter ->FilterRegistrationBean
     listener ->ServletListenerRegistrationBean   
    `
15. 如何在Springboot中使用拦截器（详细步骤参考interceptor和config中的配置即可）1.写一个拦截器实现HandlerInterceptor接口2.在WebMvc配置类中实现addInterceptors方法即可。
16. 配置错误页面跳转，首先排除springboot自带的错误处理页面@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)，页面跳转处理逻辑参考exception包下的CommonErrorPageRegistry类
17. 全局异常处理器(详细代码参考exception包下的GolbalExceptionHandler类)

### course11 课程11 Spring Boot 定制和优化内嵌的Tomca    