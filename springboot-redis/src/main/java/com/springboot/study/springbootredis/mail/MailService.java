package com.springboot.study.springbootredis.mail;

/**
 * 邮箱服务
 * @author huang
 * @PACKAGE_NAME com.springboot.study.springbootredis.mail
 * @PROJECT_NAME springboot
 * @date 2018/12/27
 */
public interface MailService {
    /**
     * 发送邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送HTML邮箱
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送带静态资源的邮件
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     */
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
