package com.email.email.service;

import javax.mail.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class emailService {

    public boolean sendEmail(String subject, String message, String to) {

        boolean flag = false;

        String from = "phpurohit2004@gmail.com";
        String pass = "bnev tgaw yohq tiwd";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        System.out.println("propertirs : = " + properties);

        properties.put("mail.smtp.host", host);
        // properties.put("mail.smtp.port", "587"); // Use 587 for TLS
        properties.put("mail.smtp.auth", "true");
        // properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS

        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.starttls.enable", "false");
        properties.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                System.out.println("Using email: " + from);
                System.out.println("Using password: " + pass);  // Print to check if it's null or correct
                return new PasswordAuthentication(from, pass);
            }
        });
        

        session.setDebug(true);

        MimeMessage m  = new MimeMessage(session);

        try {
            m.setFrom("phpurohit2004@gmail.com");
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(subject);
            m.setText(message);
            Transport.send(m);

            System.out.println("Sent successfully");
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;

    }
    
}