package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.gugawag.rpc.banco.model.Conta;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    Conta criarConta(String nConta, Double saldo) throws RemoteException;
    Conta pesquisarConta(String nConta) throws RemoteException;
    void excluirConta(String nConta) throws RemoteException;
    List<Conta> listarContas() throws RemoteException;
    
}
