package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Registry registry = LocateRegistry.getRegistry();
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    var conta = entrada.next();
                    System.out.println(banco.saldo(conta));
                    break;
                }
                case 2: {
                    System.out.println(banco.quantidadeContas());
                    break;
                }
                case 3: {
                    System.out.print("Número da conta: ");
                    var conta = entrada.next();
                    System.out.print("Saldo da conta: R$ ");
                    var saldo = entrada.nextDouble();

                    System.out.println("Conta criada:");
                    System.out.println(banco.criarConta(conta, saldo));
                    break;
                }
                case 4: {
                    System.out.print("Número da conta: ");
                    var conta = entrada.next();

                    System.out.println(banco.pesquisarConta(conta));
                    break;
                }
                case 5: {
                    System.out.print("Número da conta: ");
                    var conta = entrada.next();

                    banco.excluirConta(conta);
                    System.out.println(banco.listarContas());
                    break;
                }
                case 6: {
                     System.out.println(banco.listarContas());
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== BANCO RMI (ou FMI?!) ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Cadastrar conta");
        System.out.println("4 - Pesquisar conta");
        System.out.println("5 - Excluir conta");
        System.out.println("6 - Listar contas");
        System.out.println("9 - Sair");
        System.out.println("Coo-author: Roosevelt Henrique de Lima Ferreira");
    }

}
