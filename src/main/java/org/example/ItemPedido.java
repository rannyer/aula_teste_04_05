package org.example;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedido {

    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        if (produto == null || quantidade <= 0)
            throw new IllegalArgumentException();
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }
}