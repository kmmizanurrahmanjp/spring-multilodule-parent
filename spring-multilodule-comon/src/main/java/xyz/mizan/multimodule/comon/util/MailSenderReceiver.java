package xyz.mizan.multimodule.comon.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Component
public class MailSenderReceiver{

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(MailSenderReceiver.class);
	
	@Autowired
    public JavaMailSender emailSender;
	
	@Value("${mail.host.server}")
	private String hostServer;
	
	@Value("${mail.host.user}")
	private String hostUser;
	
	@Value("${mail.host.pass}")
	private String hostPass;
	
	@Value("${mail.recipient}")
	private String recipient;
	
 
	//application property config
    public void sendSimpleMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
    }
    
    //application property config
    public void sendSimpleMailWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {
	    MimeMessage message = emailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	     
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(text);
	         
	    FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
	    helper.addAttachment("Invoice", file);
	 
	    emailSender.send(message);
	}
    
    
    //Mail with gmail server
	public void sendMailByGmailWithAtachment(String pathToAttachment) throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(hostUser, hostPass);
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(hostPass, false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
		msg.setSubject("Test project email");
		msg.setContent("Test email", "text/html");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Mizan point email", "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		MimeBodyPart attachPart = new MimeBodyPart();

		attachPart.attachFile(pathToAttachment);
		multipart.addBodyPart(attachPart);
		msg.setContent(multipart);
		Transport.send(msg);
	}
	
	
	//
	//Email with my mail server
	public String sendEmailWithMyServer(String to, String sub, String msg) throws IOException {
		String response = "Email Send Failed";

		Properties props = new Properties();
		props.put("mail.smtp.host", hostServer);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(hostUser, hostPass);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(hostUser));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);

			Transport.send(message);
			response = "Email Send Successfully";

		} catch (MessagingException e) {
			response = "Sending Email Error";
			System.out.println(e);
		}

		return response;

	}
}
