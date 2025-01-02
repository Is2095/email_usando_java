package com.envioEmail.Email.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:email.properties") // no toma el archivo application.properties como defecto y toma el propierties indicado en classpath
public class EmailConfig {

    // definir las variables que van a contener los valores de username y password definidos en email.properties
    @Value("${email.username}")
    private String email;

    @Value("${email.password}")
    private String password;

    // crear y configurar las propiedades necesarias para el protocolo SMTP (correo saliente)
    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true"); // habilitar la autenticacion SMTP
        properties.put("mail.smtp.starttls" + ".enable", "true" ); // habilita el protocolo STARTTLS, necesario para conexiones seguras
        properties.put("mail.smtp.host", "smtp" + ".gmail.com"); // definición del host del servidor SMTP (en este caso para gmail)
        properties.put("mail.smtp.port", "587"); // definición del puerto correspondiente a gmail
        return properties;
    }

    // crear un objeto JavaMailSenderImpl de Spring para enviar correos electrónicos
    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(getMailProperties());
        mailSender.setUsername(email);
        mailSender.setPassword(password);
        return mailSender;
    }
    @Bean
    public ResourceLoader resourceLoader() {
        return new DefaultResourceLoader();
    }
}
