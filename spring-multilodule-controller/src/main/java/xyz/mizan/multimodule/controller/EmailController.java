package xyz.mizan.multimodule.controller;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.mizan.multimodule.comon.util.MailSenderReceiver;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/patient/email")
public class EmailController {
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	Environment env;

	@Autowired
	MailSenderReceiver mailSenderReceiver;
	
	
	@GetMapping("send/simple")
	public String sendSimpleMail(
			@RequestParam(value = "to", required = true) String to,
			@RequestParam(value = "subject", required = true) String subject,
			@RequestParam(value = "message", required = false) String message
			) {
		mailSenderReceiver.sendSimpleMail(to, subject, message);
		return "success";
	}
	
	@GetMapping("send/simple/with/attachment")
	public String sendSimpleMailWithAttachment(
			@RequestParam(value = "to", required = true) String to,
			@RequestParam(value = "subject", required = true) String subject,
			@RequestParam(value = "message", required = false) String message
			) throws MessagingException {
		mailSenderReceiver.sendSimpleMailWithAttachment(to, subject, message, env.getProperty("file.upload.dir")+"panda.jpg");
		return "success";
	}
}
