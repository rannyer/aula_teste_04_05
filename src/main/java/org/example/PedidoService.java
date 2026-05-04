package org.example;

import lombok.Getter;
import lombok.Setter;


public class PedidoService {
    public void adicionarProdutoAoPedido(Pedido pedido, Produto produto, int quantidade) {
        if (produto.getEstoque() < quantidade)
            throw new IllegalArgumentException();
        pedido.adicionarItem(new ItemPedido(produto, quantidade));
    }
    public void finalizarPedido(Pedido pedido) {
        for (ItemPedido item : pedido.getItens()) {
            item.getProduto().reduzirEstoque(item.getQuantidade());
        }
        pedido.finalizar();
    }
    public double calcularTotalComDesconto(Pedido pedido, double desconto) {
        double total = pedido.calcularTotal();
        return total - (total * desconto / 100);
    }
}