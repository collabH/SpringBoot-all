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

### course7 课程7 Spring Boot 扩展分析