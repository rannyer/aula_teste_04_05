package Mock;

import org.example.exemplo_mock.AuthService;
import org.example.exemplo_mock.EmailService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AuthServiceTest {
    @Test
    void deveEnviarEmailAoCriarConta(){
        EmailService emailService = mock(EmailService.class);

        AuthService authService =  new AuthService(emailService);

        authService.criarConta("usuario@gmail.com");

        verify(emailService, never()).enviarConfirmacao("usuario@gmail.com");


    }
}
