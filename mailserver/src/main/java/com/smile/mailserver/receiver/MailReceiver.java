package com.smile.mailserver.receiver;

import com.rabbitmq.client.Channel;
import com.smile.hrsys.model.Employee;
import com.smile.hrsys.model.MailConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;

public class MailReceiver {

    public static final Logger logger = LoggerFactory.getLogger(MailReceiver.class);

    @Autowired
    JavaMailSender mailSender;
    @Autowired
    MailProperties mailProperties;
    @Autowired
    TemplateEngine templateEngine;
    @Autowired
    StringRedisTemplate redisTemplate;

    @RabbitListener(queues = MailConstants.MAIL_QUEUE_NAME)
    public void handle(Message message, Channel channel) throws IOException {
        Employee employee = (Employee) message.getPayload();
        MessageHeaders headers = message.getHeaders();
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        String msgId = (String) headers.get("spring_returned_message_correlation");
        if (redisTemplate.opsForHash().entries("mail_log").containsKey(msgId)) {
            // redis包含该key, 说明该消息已经被消费国
            logger.info(msgId + ":消息已经被消费");
            channel.basicAck(tag, false);
        }

        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);

        try {
            helper.setTo(employee.getEmail());
            helper.setFrom(mailProperties.getUsername());
            helper.setSubject("入职欢迎");
            helper.setSentDate(new Date());
            Context context = new Context();
            context.setVariable("name", employee.getName());
            context.setVariable("posName", employee.getPosition());
            context.setVariable("joblevelName", employee.getJobLevel());
            context.setVariable("departmentName", employee.getDepartment());
            String mail = templateEngine.process("mail", context);
            helper.setText(mail, true);
            mailSender.send(msg);
            redisTemplate.opsForHash().put("mail_log", msgId, "smile");
            channel.basicAck(tag, false);
            logger.info(msgId + ": 邮件发送成功");
        } catch (Exception e) {
            channel.basicNack(tag, false, true);
            e.printStackTrace();
            logger.error("邮件发送失败：" + e.getMessage());
        }

    }

}
