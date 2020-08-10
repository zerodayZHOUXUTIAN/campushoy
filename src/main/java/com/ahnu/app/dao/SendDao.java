package com.ahnu.app.dao;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * 发送邮件的工具类
 *
 * @author DamonCheng@ssw.com.au
 * @date 8/4/2020 3:57 PM
 */
public class SendDao {
    /**
     * 发送人的邮箱地址
     */
    private final static String EMAIL = "";
    /**
     * SMTP密码
     */
    private final static String PASSWORD = "";
    /**
     * 接收人的邮件地址
     */
    private final static String RECEIVE = "";


    /**
     * 发送邮箱
     *
     * @param info  邮箱的内容
     * @param title 邮箱的标题
     */
    public static void send(String info, String title) {
        try {


            Properties prop = new Properties();
            // 设置QQ邮件服务器
            prop.setProperty("mail.host", "smtp.qq.com");
            // 邮件发送协议
            prop.setProperty("mail.transport.protocol", "smtp");
            // 需要验证用户名密码
            prop.setProperty("mail.smtp.auth", "true");

            // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            prop.put("mail.smtp.ssl.enable", "true");
            prop.put("mail.smtp.ssl.socketFactory", sf);

            //使用JavaMail发送邮件的5个步骤

            //创建定义整个应用程序所需的环境信息的 Session 对象

            Session session = Session.getDefaultInstance(prop, new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    //发件人邮件用户名、授权码
                    return new PasswordAuthentication(EMAIL, PASSWORD);
                }
            });


            //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
            session.setDebug(true);

            //2、通过session得到transport对象
            Transport ts = session.getTransport();

            //3、使用邮箱的用户名和授权码连上邮件服务器
            ts.connect("smtp.qq.com", EMAIL, PASSWORD);

            //4、创建邮件

            //创建邮件对象
            MimeMessage message = new MimeMessage(session);

            //指明邮件的发件人
            message.setFrom(new InternetAddress(EMAIL));

            //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(RECEIVE));

            String subject = "今日校园 / " + title;
            //邮件的标题
            message.setSubject(subject, "UTF-8");

            //邮件的文本内容
            message.setContent(info, "text/html;charset=UTF-8");

            //5、发送邮件
            ts.sendMessage(message, message.getAllRecipients());

            ts.close();
        } catch (GeneralSecurityException ex) {
            System.out.println("发送邮件失败");

        } catch (MessagingException ex) {
            System.out.println("发送邮件失败");

        }
    }

}
