package com.loren.gestionventasv3.DAO;

public class FactoriaDAO {
    
    private static ClienteDAO clienteDAO = null;
    private static ComercialDAO comercialDAO = null;
    // private static ComercialDAO comerciaDAO = null;
    // private static PedidosDAO pedidosDAO = null;
    
    public static ClienteDAO getClienteDAO(){
        if(clienteDAO == null){
            clienteDAO = new ClienteDAO();
        }
        return clienteDAO;
    }
    
    public static ComercialDAO getComercialDAO(){
        if(comercialDAO == null){
            comercialDAO = new ComercialDAO();
        }
        return comercialDAO;
    }
}
