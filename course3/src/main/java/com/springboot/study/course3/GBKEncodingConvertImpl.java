package com.springboot.study.course3;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME com.springboot.study.course3
 * @PROJECT_NAME springboot
 * @创建人 huang
 * @创建时间 2018/12/24
 */
public class GBKEncodingConvertImpl implements Condition,EncodingConvert {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}
