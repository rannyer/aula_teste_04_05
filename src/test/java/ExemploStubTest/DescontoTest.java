package ExemploStubTest;

import org.example.ExemploStub.ClienteService;
import org.example.ExemploStub.DescontoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DescontoTest {

    @Test
    void deveAplicarDescontoQuandoClienteForVip(){
        ClienteService stub = new ClienteVipStub();
        DescontoService descontoService =  new DescontoService(stub);

        double desconto =  descontoService.calcularDesconto(1L, 1000);
        assertEquals(100.0, desconto);
    }
}
