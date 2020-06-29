package com.smile.hrsys.task;

import com.smile.hrsys.model.Employee;
import com.smile.hrsys.model.MailConstants;
import com.smile.hrsys.model.MailSendLog;
import com.smile.hrsys.service.EmployeeService;
import com.smile.hrsys.service.MailSendLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MailSendTask {

    @Autowired
    MailSendLogService mailSendLogService;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    EmployeeService employeeService;

    /**
     * spring自带定时任务
     * cron = 秒(0~59) 分(0~59) 时(0~23) 天(0~28/29/30/31) 月(0~11) 年(1970~2099)
     * "/"用来指定数字的增量
     * "?"仅仅被用于天(月)和天(星期)两个子表达式，表示不指定值
     * "L"仅被用于天（月）和天（星期）两个子表达式，它是单词“last”的缩写
     * 这里每60秒触发一次
     */
    //@Scheduled(cron = "0/60 * * * * ?")
    public void mailResendTask() {

        List<MailSendLog> logs = mailSendLogService.getMailSendLogsByStatus();
        if (logs == null || logs.size() == 0) {
            return;
        }

        logs.forEach(mailSendLog -> {
            if (mailSendLog.getCount() >= 3) {
                mailSendLogService.updateMailSendLogStatus(mailSendLog.getMsgId(), 2); // 直接设置该条消息发送失败
            } else {
                mailSendLogService.updateCount(mailSendLog.getMsgId(), new Date());
                Employee emp = employeeService.getEmployeeById(mailSendLog.getEmpId());
                rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME, emp,
                        new CorrelationData(mailSendLog.getMsgId()));
            }
        });
    }


}
