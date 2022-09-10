package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.gugawag.rpc.banco.model.Conta;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private Map<String, Double> saldoContas;
    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);

        this.contas = new ArrayList<Conta>();
        this.contas.add(new Conta("1", 100.0));
        this.contas.add(new Conta("2", 156.0));
        this.contas.add(new Conta("3", 950.0));
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.get(conta);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();
    }

    @Override
    public Conta criarConta(String nConta, Double saldo) throws RemoteException {
        Conta conta = new Conta(nConta, saldo);
        this.contas.add(conta);

        return this.contas.get(this.contas.size() - 1);
    }

    @Override
    public Conta pesquisarConta(String nConta) throws RemoteException {
        return this.contas.stream()
                          .filter(conta -> nConta.equals(conta.getConta()))
                          .findAny()
                          .orElse(null);
    }

    @Override
    public void excluirConta(String nConta) throws RemoteException {
        Predicate<Conta> contaDelete = conta -> conta.getConta().equals(nConta);
        this.contas.removeIf(contaDelete);
    }

    @Override
    public List<Conta> listarContas() throws RemoteException {
        return this.contas;
    }

}
