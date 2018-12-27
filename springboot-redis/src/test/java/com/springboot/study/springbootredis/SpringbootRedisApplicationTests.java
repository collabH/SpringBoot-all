package com.springboot.study.springbootredis;

import com.alibaba.fastjson.JSON;
import com.springboot.study.springbootredis.bean.User;
import com.springboot.study.springbootredis.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class SpringbootRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * redis存储对象
     */
    @Test
    public void contextLoads() {
        User user=new User();
        user.setAge(12);
        user.setName("huang");
        redisTemplate.opsForValue().set("user",user);
        boolean exists=redisTemplate.hasKey("user");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
        Object user1 = redisTemplate.opsForValue().get("user");
        String s = JSON.toJSONString(user1);
        System.out.println(s);
    }
    @Resource(name = "stringRedisTemplate1")
    private RedisTemplate stringRedisTemplate;

    @Test
    public void test1(){
        stringRedisTemplate.opsForValue().set("name","黄世民");
        System.out.println(JSON.toJSONString(redisTemplate.opsForValue().get("user")));
    }

    @Autowired
    private  MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;
    /**
     * 测试邮箱服务
     * @throws Exception
     */
    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("935722642@qq.com","test simple mail"," hello this is simple mail");
    }

    /**
     * 测试发送Html邮件
     * @throws Exception
     */
    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>你好呀王球球 ! 爱你呦小菠萝球球，😍!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("935722642@qq.com","test simple mail",content);
    }

    /**
     * 发送带附件的邮件
     */
    @Test
    public void sendAttachmentsMail() {
        String filePath="H:\\logbak\\springboot_2018-12-26.log";
        mailService.sendAttachmentsMail("935722642@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    /**
     * 测试发送带静态资源的邮件
     */
    @Test
    public void sendInlineResourceMail() {
        String rscId = "wqq";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\h1261\\Pictures\\back.jpg";

        mailService.sendInlineResourceMail("935722642@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "王球球");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("935722642@qq.com","主题：这是模板邮件",emailContent);
    }
}

