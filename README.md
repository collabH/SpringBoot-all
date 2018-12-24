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