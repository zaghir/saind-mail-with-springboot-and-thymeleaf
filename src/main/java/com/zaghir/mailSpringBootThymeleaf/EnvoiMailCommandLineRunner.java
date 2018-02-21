package com.zaghir.mailSpringBootThymeleaf;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.zaghir.mailSpringBootThymeleaf.beans.Mail;
import com.zaghir.mailSpringBootThymeleaf.service.EmailService;

@Component
public class EnvoiMailCommandLineRunner  implements ApplicationRunner  {

	private static Logger log = LoggerFactory.getLogger(EnvoiMailCommandLineRunner.class);

	@Autowired
    private EmailService emailService;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		
		log.info("Sending Email with Thymeleaf HTML Template Example");

        Mail mail = new Mail();
        mail.setFrom("reservation.businessdecision@gmail.com");
        mail.setTo("zaghir.youssef@gmail.com");
        mail.setSubject("Sending Email with Thymeleaf HTML Template Example");

        Map model = new HashMap();
        model.put("name", "Zaghir");
        model.put("location", "FREANCE");
        model.put("signature", "https://toto.com");
        mail.setModel(model);

        emailService.sendSimpleMessage(mail);
		
	}

	
}
