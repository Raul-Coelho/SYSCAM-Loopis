package br.com.syscam.model;

import br.com.syscam.model.enums.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;
    private Double preco;
    private String fornecedor;
    private int quantidade;
}
