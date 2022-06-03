package br.espm.cambio;

import java.time.LocalDate;
import java.util.UUID;

public class Cotacao {

    private UUID idc;
    private UUID id;
    private LocalDate data;
    private double valor;

    public Cotacao() {

    }

    public Cotacao(double valor) {
        this.valor = valor;
    }

    public UUID getIdc() {
        return idc;
    }

    public void setIdc(UUID idc) {
        this.idc = idc;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
