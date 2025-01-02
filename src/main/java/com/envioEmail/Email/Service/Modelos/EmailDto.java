package com.envioEmail.Email.Service.Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {

    private String destinatario;
    private String asunto;
    private String mensaje;

}
