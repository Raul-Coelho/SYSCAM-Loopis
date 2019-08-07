package br.com.syscam.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;



@Entity
public class Movimentacao  {

    @Id
    @GeneratedValue
    private int protocolo;

    @Column(name="data_time",columnDefinition = "TIMESTAMP")
    private LocalDateTime datatime;

    private boolean isVenda;

    private Double subTotal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="produto_id")
    private Produto produto;


    public Movimentacao() {
    }

    public Movimentacao(LocalDateTime datatime, Double subTotal, boolean isVenda, Produto produto) {
        this.datatime = datatime;
        this.subTotal = subTotal;
        this.produto = produto;
        this.isVenda=isVenda;
    }

    public Movimentacao(LocalDateTime datatime, Double subTotal) {
        this.datatime = datatime;

        this.subTotal = subTotal;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public LocalDateTime getDatatime() {
        return datatime;
    }

    public void setDatatime(LocalDateTime datatime) {
        this.datatime = datatime;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public boolean isIsVenda() {
        return isVenda;
    }

    public void setIsVenda(boolean isVenda) {
        this.isVenda=isVenda;
    }

}
