package com.springboot.study.course18.mapper;

import com.springboot.study.course18.bean.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course18.mapper
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@Mapper
public interface TestMapper {

    @Select("select * from test")
    public List<Test> findList();
}
