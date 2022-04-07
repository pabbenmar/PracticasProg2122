/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablo.ud8_boletin_ej1.DAO.Ciudad;

import com.pablo.ud8_boletin_ej1.DAO.ConexionBD;
import com.pablo.ud8_boletin_ej1.POJO.Ciudad;
import com.pablo.ud8_boletin_ej1.POJO.Parque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Benavent Martínez
 */
public class CiudadDAO implements ICiudadDAO {

   Connection conn = ConexionBD.getConnection();

   @Override
   public int add(Ciudad ciudad) {
      int filas = -1;
      String sql = "INSERT INTO ciudad(nombre) VALUES (?);";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, ciudad.getNombre());
         filas = ps.executeUpdate();
         ps.close();
         return filas;
      } catch (Exception e) {
         return -1;
      }
   }

   @Override
   public List<Ciudad> ciudadesPorTamanyoParque(Parque parque) {
      List<Ciudad> lista = new ArrayList<>();
      String sql = "SELECT DISTINCT ciudad.* FROM ciudad, parque WHERE ciudad.id = parque.idCiudad AND extension > ?;";

      String sql2 = "SELECT * FROM ciudad WHERE id IN (SELECT idCiudad FROM parque WHERE extension > ?);";

      try {
         PreparedStatement ps = conn.prepareStatement(sql2);
         ps.setDouble(1, parque.getExtension());
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
            Long idAux = rs.getLong("id");
            String nomAux = rs.getString("nombre");
            Ciudad a = new Ciudad(idAux, nomAux);
            lista.add(a);
         }
         return lista;
      } catch (Exception e) {
         return null;
      }
   }

   public Ciudad findById(Ciudad ciudad) {
      String sql = "SELECT * FROM ciudad WHERE id = ?;";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setLong(1, ciudad.getId());
         ResultSet rs = ps.executeQuery();

         Ciudad a = null;
         if (rs.next()) {
            long idAux = rs.getLong("id");
            String nomAux = rs.getString("nombre");
            a = new Ciudad(idAux, nomAux);
         }
         rs.close();
         ps.close();
         return a;
      } catch (Exception e) {
         return null;
      }
   }
   public Ciudad findByName(Ciudad ciudad) {
      String sql = "SELECT * FROM ciudad WHERE nombre = ?;";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, ciudad.getNombre());
         ResultSet rs = ps.executeQuery();

         Ciudad a = null;
         if (rs.next()) {
            long idAux = rs.getLong("id");
            String nomAux = rs.getString("nombre");
            a = new Ciudad(idAux, nomAux);
         }
         rs.close();
         ps.close();
         return a;
      } catch (Exception e) {
         return null;
      }
   }

   @Override
   public long cantidadParquesPorCiudad(Ciudad ciudad) {
      long parques = -1;
      String sql = "SELECT COUNT(*) FROM parque WHERE idCiudad = ?;";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setLong(1, ciudad.getId());
         ResultSet rs = ps.executeQuery();
         if(rs.next()){
            parques = rs.getLong(1);
         }
         rs.close();
         ps.close();
         return parques;
      } catch (Exception e) {
         return -1;
      }
   }
}
