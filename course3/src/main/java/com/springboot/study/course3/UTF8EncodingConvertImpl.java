package com.springboot.study.course3;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME com.springboot.study.course3
 * @PROJECT_NAME springboot
 * @author  huang
 * @date  2018/12/24
 */
public class UTF8EncodingConvertImpl implements EncodingConvert, Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}
