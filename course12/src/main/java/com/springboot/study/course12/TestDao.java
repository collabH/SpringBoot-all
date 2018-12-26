package com.springboot.study.course12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * 测试JdbcTemplate
 *
 * @author huang
 * @PACKAGE_NAME com.springboot.study.course12
 * @PROJECT_NAME springboot
 * @date 2018/12/26
 */
@Repository
public class TestDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addTest(String name) {
        String sql = "insert into test(name)values('" + name + "')";
        jdbcTemplate.execute(sql);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addTest(String  ... names) throws FileNotFoundException {
        for (String name : names) {
            String sql = "insert into test(name)values('" + name + "')";
            jdbcTemplate.execute(sql);
            if ("".equals("")){
                throw new FileNotFoundException();
            }
        }
    }
}
