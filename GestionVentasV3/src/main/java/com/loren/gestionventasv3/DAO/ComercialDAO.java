/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loren.gestionventasv3.DAO;

import java.sql.Connection;
import com.loren.gestionventasv3.POJO.Comercial;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class ComercialDAO implements IOperationsCRUD<Comercial> {

   private Connection conn = ConexionBD.getConnection();

   @Override
   public List<Comercial> getAll() {
      List<Comercial> lista = new ArrayList<>();
      try {
         String sql = "SELECT * FROM comercial;";
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql);

         while (rs.next()) {
            long idAux = rs.getLong("id");
            String nomAux = rs.getString("nombre");
            String ap1Aux = rs.getString("apellido1");
            String ap2Aux = rs.getString("apellido2");
            float comision = rs.getFloat("comision");

            Comercial a = new Comercial(idAux, nomAux, ap1Aux, ap2Aux, comision);

            lista.add(a);

         }
         rs.close();
         st.close();
         return lista;

      } catch (Exception e) {
         return null;
      }
   }

   @Override
   public Comercial findById(Comercial object) {
      try {
         String sql = "SELECT * FROM comercial WHERE id = ?";
         Comercial a = null;
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setLong(1, object.getId());
         ResultSet rs = ps.executeQuery();

         if (rs.next()) {
            long idAux = rs.getLong("id");
            String nomAux = rs.getString("nombre");
            String ap1Aux = rs.getString("apellido1");
            String ap2Aux = rs.getString("apellido2");
            float comision = rs.getFloat("comision");

            a = new Comercial(idAux, nomAux, ap1Aux, ap2Aux, comision);

         }
         rs.close();
         ps.close();
         return a;

      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   @Override
   public int add(Comercial object) {
      int filas;
      try {
         String sql = "INSERT INTO comercial(nombre,apellido1,apellido2,comision) VALUES (?,?,?,?);";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, object.getNombre());
         ps.setString(2, object.getApellido1());
         ps.setString(3, object.getApellido2());
         ps.setFloat(4, object.getComision());

         filas = ps.executeUpdate();

      } catch (Exception e) {
         return -1;
      }
      return filas;
   }

   @Override
   public int update(Comercial object) {
      int filas;
      try {
         String sql = "UPDATE comercial SET nombre = ?, apellido1 = ?, apellido2 = ?, comision = ? WHERE id = ?;";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, object.getNombre());
         ps.setString(2, object.getApellido1());
         ps.setString(3, object.getApellido2());
         ps.setFloat(4, object.getComision());
         ps.setLong(5, object.getId());

         filas = ps.executeUpdate();

      } catch (Exception e) {
         return -1;
      }
      return filas;
   }

   @Override
   public int delete(Comercial object) {
      int filas;
      try {
         String sql = "DELETE FROM comercial WHERE id = ?;";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setLong(1, object.getId());

         filas = ps.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
         return -1;
      }
      return filas;
   }

   public List<Comercial> findByNombre(Comercial object) {
      String sql = "SELECT * FROM comercial WHERE nombre = ?";
      List<Comercial> lista = new ArrayList<Comercial>();
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, object.getNombre());
         ResultSet rs = ps.executeQuery();
         Comercial a = null;
         while (rs.next()) {
            Long idAux = rs.getLong("id");
            String nomAux = rs.getString("nombre");
            String ape1Aux = rs.getString("apellido1");
            String ape2Aux = rs.getString("apellido2");
            float comAux = rs.getFloat("comision");
            // Crea el cliente y lo añade a la lista
            a = new Comercial(idAux, nomAux, ape1Aux, ape2Aux, comAux);
            lista.add(a);
         }
         rs.close();
         ps.close();
         return lista;
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   public List<Comercial> findByApellido(Comercial object) {
      String sql = "SELECT * FROM comercial WHERE apellido1 LIKE ?";
      List<Comercial> lista = new ArrayList<Comercial>();
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, "%" + object.getApellido1() + "%");
         ResultSet rs = ps.executeQuery();
         Comercial a = null;
         while (rs.next()) {
            Long idAux = rs.getLong("id");
            String nomAux = rs.getString("nombre");
            String ape1Aux = rs.getString("apellido1");
            String ape2Aux = rs.getString("apellido2");
            float comAux = rs.getFloat("comision");
            // Crea el comercial y lo añade a la lista
            a = new Comercial(idAux, nomAux, ape1Aux, ape2Aux, comAux);
            lista.add(a);
         }
         rs.close();
         ps.close();
         return lista;
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

}
