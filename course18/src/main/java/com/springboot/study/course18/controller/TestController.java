package com.springboot.study.course18.controller;

import com.springboot.study.course18.bean.Test;
import com.springboot.study.course18.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;
    @GetMapping("/info")
    public List<Test>info(){
        return testMapper.findList();
    }
}
