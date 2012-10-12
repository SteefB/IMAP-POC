package application;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import models.Email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailSender {

	static void sendMail(List<Email> emails) throws EmailException {
	
		  
		for(Email mail : emails) {
		  SimpleEmail email = new SimpleEmail();
		  email.setHostName("localhost");
		  for(String receiver : mail.getReceivers())
		  {
			  email.addTo(receiver);
		  } 
		  email.setFrom(mail.sender,mail.getSenderName());
		  email.setSubject(mail.getSubject());
		  email.setMsg(mail.getMessage());
		  email.send();	
		}
		
		
//		
//		Properties props = new Properties();
//	props.put("mail.smtp.host", "smtp.gmail.com");
//	props.put("mail.smtp.socketFactory.port", "465");
//	props.put("mail.smtp.socketFactory.class",
//			"javax.net.ssl.SSLSocketFactory");
//	props.put("mail.smtp.auth", "true");
//	props.put("mail.smtp.port", "465");
//
//	Session session = Session.getInstance(props,
//		new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("logicaiamppoc@gmail.com","testaccount");
//			}
//		});
//
//	try {
//
//		MimeMessage message = new MimeMessage(session);
//		message.setFrom(new InternetAddress("sburghouts@gmail.com"));
//		message.setRecipients(Message.RecipientType.TO,
//				InternetAddress.parse("logicaiamppoc@gmail.com"));
//		message.setSubject("Testing Subject");
//		message.setText("Dear Mail Crawler," +
//				"\n\n No spam to my email, please!");
//
// 
//        // add the Multipart to the message
//       // msg.setContent(mp);
//		
//		// improved mail send
//		message.saveChanges(); // implicit with Transport.send()
//        Transport tr = session.getTransport("smtp");
//        tr.connect("smtp.gmail.com", "logicaiamppoc@gmail.com", "testaccount");
//        message.saveChanges();   // don't forget this
//        tr.sendMessage(message, message.getAllRecipients());
//        tr.close();
//        
//        //Transport.send(message);
//
//		System.out.println("Done");
//
//	} catch (MessagingException e) {
//		throw new RuntimeException(e);
//	}
}
}
