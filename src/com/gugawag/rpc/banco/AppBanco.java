package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppBanco {

    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        BancoServiceIF bancoService = new BancoServiceServer();

        Registry registry = LocateRegistry.createRegistry(1099);
        
        registry.rebind("BancoService", bancoService);

        System.out.println("Service de banco registrado ....");
    }
}
