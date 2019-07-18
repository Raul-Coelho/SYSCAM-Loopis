package br.com.syscam.model;

import br.com.syscam.model.enums.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "produto")
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

//    @OneToOne(mappedBy = "protocolo")
//    private Movimentacao movimentacao;

    public Produto() {
    }

    public Produto(String descricao, CategoriaProduto categoria, Double preco, String fornecedor, int quantidade) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

//    public Movimentacao getMovimentacao() {
//        return movimentacao;
//    }
//
//    public void setMovimentacao(Movimentacao movimentacao) {
//        this.movimentacao = movimentacao;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return codigo == produto.codigo &&
                quantidade == produto.quantidade &&
                Objects.equals(descricao, produto.descricao) &&
                categoria == produto.categoria &&
                Objects.equals(preco, produto.preco) &&
                Objects.equals(fornecedor, produto.fornecedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricao, categoria, preco, fornecedor, quantidade);
    }
}
