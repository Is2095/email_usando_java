
# Email

## Envío de email con Java

Este proyecto permite el envío de emails a un destinatario específico, definiendo el asunto y el cuerpo del mensaje.

---

## Tecnología usada

**Server:** Java, Spring boot

---

## Requerimientos

Se requiere tener instalado:

1. **Java 17+** 
2. **Dependencias de Spring Boot:**
    - `spring-boot-starter-mail`  
   - `spring-boot-starter-thymeleaf`  
   - `spring-boot-starter-web`  
   - `spring-boot-starter-test`
3. **lombok**
4. **Credenciales de Gmail:**
    - `username`: Correo del remitente (el email desde el cual se enviarán los mensajes).  
    - `password`: Contraseña específica para aplicaciones de Gmail (generada en la cuenta Google).

---

## Ejecución local

1. Clona el repositorio:

Crea una carpeta para el proyecto, accede a ella desde tu terminal preferida y ejecuta:

```bash
  git clone https://github.com/Is2095/email_usando_java.git
```

2. Accede al directorio del proyecto:

```bash
  cd emeail
```

3. Instala las dependencias:
Ejecuta el siguiente comando para instalar todas las dependencias del proyecto:

```bash
  * mvn clean install
```

4. Configura las credenciales:
Crea un archivo llamado email.properties dentro de la carpeta resources, y coloca las siguientes propiedades con los valores correspondientes:

```
email.username=tu_correo@gmail.com
email.password=contraseña_generada
```

5. Ejecuta la aplicación en tu editor de código.

---


## Referencias de la API

##### Endpoint POST /send_email

Parámetros:

| Parámetro | Ubicación    | Descripción validación        |
| :-------- | :------- | :------------------------- |
| `destinatario` | `body` | Dirección de correo del destinatario. | 
| `asunto` | `body` | Asunto del email. | 
| `mensaje` | `body` | Contenido del mensaje. | 

Ejemplo de cuerpo de la solicitud:

```
{
  "destinatario": "ejemplo@gmail.com",
  "asunto": "Prueba de envío",
  "mensaje": "Hola, este es un mensaje de prueba."
}
```

Respuesta de éxito:

```
{
	"mensaje": "correo enviado correctamente"
}

```

----

## 🔗 Links
[![PortFolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://portfolio-ismael-diaz.vercel.app)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/ismael-diaz-3b440b27a)


## Autor

- Creado por [@Is2095](https://github.com/Is2095)
