package com.springboot.study.course12;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootApplication
@EnableTransactionManagement //启用事务
public class Course12Application {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        ConfigurableApplicationContext run = SpringApplication.run(Course12Application.class, args);
        DataSource da = run.getBean(DataSource.class);
        //Connection connection = da.getConnection();
        //System.out.println(connection.getCatalog());
        run.getBean(TestDao.class).addTest("黄世民","王媛","张三丰");
        System.out.println(da.getClass());
    }

}

