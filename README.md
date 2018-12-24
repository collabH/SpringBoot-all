# SpringBoot-all
SpringBoot详细入门DEMO
### course1  课程一 SpringBoot快速入门
    https://start.spring.io/ Springboot项目快速构建网站
    
    @SpringBootApplication注解
    查看源码发现它相当于SpringBootConfiguration Springboot配置类似于Configuration注解
    EnableAutoConfiguration 自动注入配置
    ComponentScan 扫描 这三个注解
    
### course2 课程2  SpringBoot配置分析    
    默认配置文件application.properties默认的位置在classpath根目录，或者是classpath/config目录下
    file:/，file:config/
               也可以使用yaml格式,application.yml或者application.yaml我这里使用这种方式
    application中是自定义参数，在Courese2Application用三种方式取得配置文件中的值
    1.@Value  Spring注解 默认值方式为${"hello:huangsm"}
    2.Environment   SpringBoot新特性，通过键值对的方式获取配置值      
    3.通过@ConfigurationProperties(prefix = "huel") 代码参考Huel实体类
     
    
    