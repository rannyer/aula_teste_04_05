package Dummy;

import org.example.Produto;
import org.junit.jupiter.api.Test;

public class DummyTest {
    @Test
    void testarDummy(){
        Produto dummy = new Produto(1L, "Qualquer nome", 10, 1);
//        emailService.enviarEmail(cliente, dummy, "Cliente comprou esse produto");

    }
}
