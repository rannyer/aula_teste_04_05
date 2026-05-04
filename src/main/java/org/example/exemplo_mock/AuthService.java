package org.example.exemplo_mock;

import org.example.PedidoService;

public class AuthService {
    private EmailService emailService;

    public AuthService(EmailService emailService){
        this.emailService = emailService;
    }

    public void criarConta(String email){
        emailService.enviarConfirmacao(email);

    }

}
