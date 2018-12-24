package com.springboot.study.course4;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.List;

/**
 * 只要spring容器bean的包在这里，就在spring装配起来打印出来
 */
public class EchoImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        /*
        得到注解的信息
         */
        String[] arr = (String[]) importingClassMetadata.getAnnotationAttributes(EnableEcho.class.getName()).get("packages");
        List<String> packages = Arrays.asList(arr);
        /**
         *  数组数据
         */
        System.out.println(packages);
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(EchoBeanPostProcessor.class);
        /*
        设置EchoBeanPostProcessor中list的值
         */
        beanDefinitionBuilder.addPropertyValue("packages", packages);
        registry.registerBeanDefinition(EchoBeanPostProcessor.class.getName(), beanDefinitionBuilder.getBeanDefinition());
    }
}
