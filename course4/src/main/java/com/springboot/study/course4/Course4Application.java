package com.springboot.study.course4;

import com.springboot.study.course4.dog.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @EnableAsync
 * @Import 将类或者配置类导入并且装配到Spring容器中
 */
@SpringBootApplication
@EnableAsync
//@Import(User.class)
//@Import(MyImportSelector.class)
//@Eanblelog(name = "spring log")
@Import(MyImportBeanDefinitionRegistrar.class)
@EnableEcho(packages = {"com.springboot.study.course4.cat","com.springboot.study.course4.dog"})
public class Course4Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Course4Application.class, args);
        run.getBean(Runnable.class).run();
        System.out.println(run.getBean(User.class));
        System.out.println("----end---");
        run.close();
    }

}

