package br.com.syscam.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;



@Entity
public class Movimentacao  {

    @Id
    @GeneratedValue
    private int protocolo;

    @Column(name="data",columnDefinition = "DATE")
    private LocalDate data;

    @Column(name="time", columnDefinition = "TIME")
    private LocalTime time;

    private boolean isVenda;

    private Double subTotal;

    @OneToOne
    @JoinColumn(name="produto_id")
    private Produto produto;


    public Movimentacao() {
    }

    public Movimentacao(LocalDate data,LocalTime time, Double subTotal, boolean isVenda, Produto produto) {
        this.data = data;
        this.time=time;
        this.subTotal = subTotal;
        this.produto = produto;
        this.isVenda=isVenda;
    }

    public Movimentacao(LocalDate data,LocalTime time, Double subTotal) {
        this.data = data;
        this.time=time;

        this.subTotal = subTotal;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public boolean isVenda() {
        return isVenda;
    }

    public void setVenda(boolean venda) {
        isVenda = venda;
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
