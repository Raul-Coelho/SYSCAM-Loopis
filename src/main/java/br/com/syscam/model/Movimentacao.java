package br.com.syscam.model;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


@Entity
@SequenceGenerator(name="rand_protocol",sequenceName = "protocol_rand",initialValue = Calendar.YEAR*100,allocationSize = 1)
public class Movimentacao  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rand_protocol")
    private int protocolo;
    @Temporal(TemporalType.DATE)
    private Date data;
    @Temporal(TemporalType.TIME)
    private Time hora;
    private float subTotal;

    @OneToOne
    private Produto produto;


    public Movimentacao() {
    }

    public Movimentacao(Date data, Time hora, float subTotal, Produto produto) {
        this.data = data;
        this.hora = hora;
        this.subTotal = subTotal;
        this.produto = produto;
    }

    public Movimentacao(Date data, Time hora, float subTotal) {
        this.data = data;
        this.hora = hora;
        this.subTotal = subTotal;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimentacao that = (Movimentacao) o;
        return protocolo == that.protocolo &&
                Float.compare(that.subTotal, subTotal) == 0 &&
                Objects.equals(data, that.data) &&
                Objects.equals(hora, that.hora) &&
                Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(protocolo, data, hora, subTotal, produto);
    }
}
