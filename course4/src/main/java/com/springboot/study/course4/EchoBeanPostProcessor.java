package com.springboot.study.course4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.List;
public class EchoBeanPostProcessor implements BeanPostProcessor {

    private List<String> packages;

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (String aPackage : packages) {
            if (bean.getClass().getName().startsWith(aPackage)) {
                System.out.println("echo bean:" + bean.getClass().getName());
            }
        }
        return bean;
    }
}
