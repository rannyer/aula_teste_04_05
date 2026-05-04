import org.example.Pedido;
import org.example.PedidoService;
import org.example.Produto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PedidoIntegrationTest {
    @Test
    void deveAdicionarProdutosFinalizardPedidoRedizorEstoqueECalcularTotal(){
        Produto monitor = new Produto(1L, "Monitor Java 2000", 3000.0, 10);
        Produto mouse = new Produto(2L, "Mouse Junit Razer Power", 100.0, 5);

        Pedido pedido =  new Pedido();
        PedidoService service =  new PedidoService();

        service.adicionarProdutoAoPedido(pedido, monitor, 2);
        service.adicionarProdutoAoPedido(pedido, mouse, 3);

        double total =  pedido.calcularTotal();

        service.finalizarPedido(pedido);

        assertEquals(6300, total);
        assertTrue(pedido.isFinalizado());
        assertEquals(8, monitor.getEstoque());
        assertEquals(2, mouse.getEstoque());
        assertEquals(2, pedido.getItens().size());
    }

    @Test
    void naoDeveFinalizarPedidoQuandoProdutoNaoTemEstoqueSuficiente(){
        Produto produto =  new Produto(1L, "Teclado M-Ock", 200, 1);

        Pedido pedido = new Pedido();
        PedidoService service =  new PedidoService();

        assertThrows(IllegalArgumentException.class, () ->{
            service.adicionarProdutoAoPedido(pedido, produto, 5);
        });

        assertFalse(pedido.isFinalizado());
        assertEquals(1, produto.getEstoque());
        assertEquals(0, pedido.getItens().size());

    }
}
