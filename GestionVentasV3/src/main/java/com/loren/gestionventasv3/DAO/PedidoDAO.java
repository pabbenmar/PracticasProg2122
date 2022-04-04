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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class PedidoDAO implements IOperationsCRUD<Pedido> {

   Connection conn = ConexionBD.getConnection();

   @Override
   public List<Pedido> getAll() {
      // Creamos la conexion
      List<Pedido> lista = new ArrayList<Pedido>();
      try {
         // Creamos un objeto para ejecutar la consulta
         Statement st = conn.createStatement();
         String sql = "SELECT * FROM pedido";
         // Obtenemos los resultados de la consulta
         ResultSet rs = st.executeQuery(sql);
         // Recorremos los resultados
         while (rs.next()) {
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
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   @Override
   public Pedido findById(Pedido object) {
      Pedido a = null;
      try {
         // Creamos un objeto para ejecutar la consulta
         String sql = "SELECT * FROM pedido WHERE id = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         // Obtenemos los resultados de la consulta
         ResultSet rs = ps.executeQuery();
         // Recorremos los resultados
         if (rs.next()) {
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
            a = new Pedido(idAux, totAux, fecAux, cliente, comercial);
         }
         // Cerrar los objetos que usan para las consultas
         rs.close();
         ps.close();
         // Devolvemos la lista
         return a;
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   @Override
   public int add(Pedido object) {
      int filas = -1;
      String sql = "INSERT INTO pedido(total, fecha, id_cliente,id_comercial)"
              + "VALUES (?,?,?,?);";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setDouble(1, object.getTotal());
         ps.setDate(2, object.getFecha());
         ps.setLong(3, object.getCliente().getId());
         ps.setLong(4, object.getComercial().getId());
         filas = ps.executeUpdate();
         return filas;
      } catch (Exception e) {
         return filas;
      }
   }

   @Override
   public int update(Pedido object) {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   }

   @Override
   public int delete(Pedido object) {
      int filas = -1;
      String sql = "DELETE FROM pedidos WHERE id = ?;";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setLong(1, object.getId());
         filas = ps.executeUpdate();
         return filas;
      } catch (Exception e) {
         return filas;
      }

   }

   public void loadPedidosByNombreCliente(Cliente cliente) {
      String sql = "SELECT a.* FROM pedido a, cliente b "
              + "WHERE a.id_cliente = b.id AND b.nombre = ?";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, cliente.getNombre());
         ResultSet rs = ps.executeQuery();
         while (rs.next()) {
            Long idAux = rs.getLong("id");
            Double totAux = rs.getDouble("total");
            Date fecAux = rs.getDate("fecha");
            // Long cliAux = rs.getLong("id_cliente"); No hace falta porque ya esta validado
            Long comAux = rs.getLong("id_comercial");

//                Extraemos objeto comercial desde su id
            Comercial comercial = new Comercial();
            comercial.setId(comAux);
            comercial = FactoriaDAO.getComercialDAO().findById(comercial);

            // Crea el cliente y lo añade a la lista
            Pedido a = new Pedido(idAux, totAux, fecAux, cliente, comercial);
            cliente.getListaPedidos().add(a);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
