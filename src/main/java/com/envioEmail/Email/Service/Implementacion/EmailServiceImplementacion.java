package com.envioEmail.Email.Service.Implementacion;

import com.envioEmail.Email.Service.IEmailService;
import com.envioEmail.Email.Service.Modelos.EmailDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImplementacion implements IEmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    private EmailServiceImplementacion(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendEmail(EmailDto emailDto) throws MessagingException {
        try {
            MimeMessage message =
                    javaMailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(emailDto.getDestinatario());
            helper.setSubject(emailDto.getAsunto());
//        helper.setText(emailDto.getMensaje()); // si enviamos texto plano

            Context context = new Context();
            context.setVariable("mensaje", emailDto.getMensaje());
            String contentHTML = templateEngine.process("email.html", context);

            helper.setText(contentHTML, true); // el true es porque enviamos contenido html
            javaMailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("error al enviar el correo electrónico" + e.getMessage(), e);
        }

    }
}
