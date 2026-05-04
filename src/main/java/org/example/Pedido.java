package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pedido {
    private List<ItemPedido> itens = new ArrayList<>();
    private boolean finalizado = false;

    public void adicionarItem(ItemPedido item) {
        if (finalizado) throw new IllegalStateException();
        itens.add(item);
    }
    public double calcularTotal() {

        return itens.stream()
                .mapToDouble(ItemPedido::calcularSubtotal)
                .sum();
    }
    public void finalizar() {
        if (itens.isEmpty()) throw new IllegalStateException();
        finalizado = true;
    }
}