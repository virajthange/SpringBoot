package com.spider.__Mail_Sender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//qxue ovub cmrl sxtz
@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom("virajst21hite@student.mes.ac.in");
        simpleMailMessage.setSubject("Offer offer offer");
        simpleMailMessage.setText("Crack CA intermediate with us, study with us , we are going to give you again the opportunity to study and crack the CA examination again . Don't watch reels entire day utilize your time to do something great ");
        javaMailSender.send(simpleMailMessage);
    }

}
