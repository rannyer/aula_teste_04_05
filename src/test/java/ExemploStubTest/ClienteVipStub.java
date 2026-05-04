package ExemploStubTest;

import org.example.ExemploStub.ClienteService;

public class ClienteVipStub implements ClienteService {
    @Override
    public boolean isClienteVip(Long clienteId) {
        return true;
    }
}
