package com.willi.wl.utils;

import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: William
 * @Description:
 * @Date: 2018/8/17 15:32
 **/
@Component
@PropertySource(value = "classpath:mail.properties")
public class EmailUtil {

    private static final Logger logger = LoggerFactory.getLogger(EmailUtil.class);

    @Autowired
    private Environment env;

    private static String auth;
    private static String host;
    private static String protocol;
    private static int port;
    private static String authName;
    private static String password;
    private static boolean isSSL;
    private static String charset ;
    private static String timeout;

    @PostConstruct
    public void initParam() {
        auth = env.getProperty("mail.smtp.auth");
        host = env.getProperty("mail.host");
        protocol = env.getProperty("mail.transport.protocol");
        port = env.getProperty("mail.smtp.port", Integer.class);
        authName = env.getProperty("mail.auth.name");
        password = env.getProperty("mail.auth.password");
        charset = env.getProperty("mail.send.charset");
        isSSL = env.getProperty("mail.is.ssl", Boolean.class);
        timeout = env.getProperty("mail.smtp.timeout");
    }

    /**
     *发送邮件
     * @param subject 主题
     * @param toUsers 收件人
     * @param ccUsers 抄送
     * @param content 邮件内容
     * @param attachfiles 附件列表  List<Map<String, String>> key: name && file
     * @return
     */
    public static boolean sendEmail(String subject, String[] toUsers, String[] ccUsers,
                                    String content, List<Map<String, String>> attachfiles) {
        boolean flag = true;
        try{
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            javaMailSender.setHost(host);
            javaMailSender.setProtocol(protocol);
            javaMailSender.setPort(port);
            javaMailSender.setUsername(authName);
            javaMailSender.setPassword(password);
            javaMailSender.setDefaultEncoding(charset);

            Properties properties = new Properties();
            properties.setProperty("mail.stmp.auth", auth);
            properties.setProperty("mail.stmp.timeout", timeout);
            if(isSSL) {
                MailSSLSocketFactory socketFactory = null;
                try{
                    socketFactory = new MailSSLSocketFactory();
                    socketFactory.setTrustAllHosts(true);
                    properties.put("mail.smtp.ssl.enable", "true");
                    properties.put("mail.smtp.ssl.socketFactory", socketFactory);
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
                javaMailSender.setJavaMailProperties(properties);

                MimeMessage mailMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true);
                messageHelper.setTo(toUsers);
                if(ccUsers != null && ccUsers.length > 0) {
                    messageHelper.setCc(ccUsers);
                }
                messageHelper.setFrom(authName);
                messageHelper.setSubject(subject);
                messageHelper.setText(content, true);

                if(attachfiles != null && attachfiles.size() > 0) {
                    for (Map<String, String> attachfile : attachfiles) {
                        String attachFileName = attachfile.get("name");
                        File file = new File(attachfile.get("file"));
                        messageHelper.addAttachment(attachFileName, file);

                    }
                }
                javaMailSender.send(mailMessage);
            }
        } catch (MessagingException e) {
            e.printStackTrace();

            logger.info("邮件发送失败");
            flag = false;
        }

        return flag;
    }
}
