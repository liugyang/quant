package com.connect.stock.spirit.component;

import com.connect.stock.spirit.Config;
import com.connect.stock.spirit.MailConfig;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan
@Service("mailService")
public class MailService
{

  @Autowired
  @Qualifier("config")
  private Config config;

  public void sendMsg(String from, String[] to, String subject, String context)
    throws AddressException, MessagingException
  {
    Properties properties = new Properties();
    properties.put("mail.transport.protocol", "smtp");
    properties.put("mail.smtp.host", this.config.getMailConfig().getHost());
    properties.put("mail.smtp.port", this.config.getMailConfig().getPort());
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.debug", "true");
    Session session = Session.getInstance(properties);
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    InternetAddress[] tos = new InternetAddress[to.length];
    for (int i = 0; i < to.length; i++) {
      tos[i] = new InternetAddress(to[i]);
    }
    message.setRecipients(Message.RecipientType.TO, tos);
    message.setSubject(subject);
    message.setText(context);
    Transport transport = session.getTransport();
    transport.connect(this.config.getMailConfig().getUsername(), this.config.getMailConfig().getPassword());
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
  }
}