package com.envioEmail.Email.Service;

import com.envioEmail.Email.Service.Modelos.EmailDto;
import jakarta.mail.MessagingException;

public interface IEmailService {
    public void sendEmail(EmailDto emailDto) throws MessagingException;
}
