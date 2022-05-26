package br.espm.cambio;

import java.util.UUID;

public class Cotacao {

    private UUID idc;
    private UUID id;
    private String data;
    private double valor;

    public Cotacao() {

    }

    public Cotacao( String data, double valor) {
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
