package com.envioEmail.Email.Controller;

import com.envioEmail.Email.Service.IEmailService;
import com.envioEmail.Email.Service.Modelos.EmailDto;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/send_email")
public class EmailController {

    @Autowired
    IEmailService emailService;

    @PostMapping()
    private ResponseEntity<Map<String, String>> sendEmail(@RequestBody EmailDto emailDto) throws MessagingException {
        emailService.sendEmail(emailDto);
        Map<String, String> mensaje = new HashMap<>();
        mensaje.put("mensaje", "correo enviado correctamente");
        return  new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
