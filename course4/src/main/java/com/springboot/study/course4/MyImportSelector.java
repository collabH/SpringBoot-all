package com.springboot.study.course4;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义一个ImportSelector实现类
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        /**
         * 获取注解的信息，然后更具信息去动态的返回需要被spring管理的bean
         */
        System.out.println(importingClassMetadata.getAnnotationAttributes(Eanblelog.class.getName()));
        return new String[]{"com.springboot.study.course4.User"};
    }
}
