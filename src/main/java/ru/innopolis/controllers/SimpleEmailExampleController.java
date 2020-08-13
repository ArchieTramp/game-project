package ru.innopolis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.innopolis.security.config.MyConstants;

/**
 * SimpleEmailExampleController
 *
 * @author "Andrei Prokofiev"
 */

@Controller
public class SimpleEmailExampleController {

    @Autowired
    public JavaMailSender emailSender;

//    @ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Тестовое письмо");
        message.setText("Привет из игры");
        this.emailSender.send(message);

        return "redirect:/";
//        return "Письмо отправлено";
    }

}
