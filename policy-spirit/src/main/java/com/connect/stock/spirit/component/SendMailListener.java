package com.connect.stock.spirit.component;

import com.connect.stock.spirit.event.SendMailEvent;
import com.connect.stock.spirit.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

@Component
public class SendMailListener implements ApplicationListener<SendMailEvent> {

    private static final Logger logger = LoggerFactory.getLogger(SendMailListener.class);
    @Autowired
    @Qualifier("mailService")
    private MailService mailService;

    @Override
    public void onApplicationEvent(SendMailEvent sendMailEvent) {
        try {
            this.mailService.sendMsg(sendMailEvent.getFrom(), sendMailEvent.getTo(), sendMailEvent.getTitle(), sendMailEvent.getContext());
            logger.info("Sent email from:"+sendMailEvent.getFrom()+" to:"+sendMailEvent.getSTo()+" Subject:"+sendMailEvent.getTitle()+" Context:"+sendMailEvent.getContext());
        } catch (AddressException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (MessagingException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
