package com.envioEmail.Email.Controller;

import com.envioEmail.Email.Service.IEmailService;
import com.envioEmail.Email.Service.Modelos.EmailDto;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send_email")
public class EmailController {

    @Autowired
    IEmailService emailService;

    @PostMapping()
    private ResponseEntity<String> sendEmail(@RequestBody EmailDto emailDto) throws MessagingException {
        emailService.sendEmail(emailDto);
        return  new ResponseEntity<>("correo enviado correctamente", HttpStatus.OK);
    }
}
