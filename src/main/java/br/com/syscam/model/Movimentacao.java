package br.com.syscam.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;




@Entity
public class Movimentacao  {

    @Id
    @GeneratedValue
    private int protocolo;

    @Column(name="data",columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @Column(name="time", columnDefinition = "TIME")
    private LocalTime time;

    private boolean isVenda;

    private Double subTotal;

    private String nomeProduto;

    private int quantMovimento;

    public Movimentacao() {
    }

    public Movimentacao(LocalDate data, LocalTime time, boolean isVenda, Double subTotal, String nomeProduto, int quantMovimento) {
        this.data = data;
        this.time = time;
        this.isVenda = isVenda;
        this.subTotal = subTotal;
        this.nomeProduto = nomeProduto;
        this.quantMovimento = quantMovimento;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantMovimento() {
        return quantMovimento;
    }

    public void setQuantMovimento(int quantMovimento) {
        this.quantMovimento = quantMovimento;
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

    public boolean isIsVenda() {
        return isVenda;
    }

    public void setIsVenda(boolean isVenda) {
        this.isVenda=isVenda;
    }

}
