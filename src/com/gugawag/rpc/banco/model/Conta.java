package com.gugawag.rpc.banco.model;

import java.io.Serializable;

public class Conta implements Serializable {
    private String conta;
    private double saldo;

    public Conta(String conta, double saldo) {
        this.conta = conta;
        this.saldo  = saldo;
    }

    public String getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return String.format("N° conta: %s - Saldo: R$ %.2f", this.conta, this.saldo);
    }
}
