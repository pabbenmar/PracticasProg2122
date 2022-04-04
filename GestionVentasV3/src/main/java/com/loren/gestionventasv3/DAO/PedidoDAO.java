/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loren.gestionventasv3.DAO;

import com.loren.gestionventasv3.POJO.Cliente;
import com.loren.gestionventasv3.POJO.Comercial;
import com.loren.gestionventasv3.POJO.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class PedidoDAO implements IOperationsCRUD<Pedido>{
   Connection conn = ConexionBD.getConnection();

   @Override
   public List<Pedido> getAll() {
      // Creamos la conexion
        List<Pedido> lista =  new ArrayList<Pedido>();
        try{
            // Creamos un objeto para ejecutar la consulta
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM pedido";
            // Obtenemos los resultados de la consulta
            ResultSet rs = st.executeQuery(sql);
            // Recorremos los resultados
            while(rs.next()){
                Long idAux = rs.getLong("id");
                Double totAux = rs.getDouble("total");
                Date fecAux = rs.getDate("fecha");
                Long cliAux = rs.getLong("id_cliente");
                Long comAux = rs.getLong("id_comercial");
                
//                Extraemos objeto cliente desde su id
                Cliente cliente = new Cliente();
                cliente.setId(cliAux);
                cliente = FactoriaDAO.getClienteDAO().findById(cliente);
                
//                Extraemos objeto comercial desde su id
                Comercial comercial = new Comercial();
                comercial.setId(comAux);
                comercial = FactoriaDAO.getComercialDAO().findById(comercial);
                
                
                // Crea el cliente y lo añade a la lista
                Pedido a = new Pedido(idAux, totAux, fecAux, cliente, comercial);
                lista.add(a);
            }
            // Cerrar los objetos que usan para las consultas
            rs.close();
            st.close();
            // Devolvemos la lista
            return lista;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
   }

   @Override
   public Pedido findById(Pedido object) {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   }

   @Override
   public int add(Pedido object) {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   }

   @Override
   public int update(Pedido object) {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   }

   @Override
   public int delete(Pedido object) {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   }
}
