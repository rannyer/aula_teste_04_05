package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private int estoque;


    public void reduzirEstoque(int quantidade) {
        if (quantidade <= 0) throw new IllegalArgumentException();
        if (quantidade > estoque) throw new IllegalArgumentException();
        estoque -= quantidade;
    }

}