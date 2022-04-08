/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablo.ud8_boletin_ej1.DAO.Parque;

import com.pablo.ud8_boletin_ej1.DAO.ConexionBD;
import com.pablo.ud8_boletin_ej1.DAO.FactoriaDAO;
import com.pablo.ud8_boletin_ej1.POJO.Ciudad;
import com.pablo.ud8_boletin_ej1.POJO.Parque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Benavent Martínez
 */
public class ParqueDAO implements IParqueDAO {

   Connection conn = ConexionBD.getConnection();

   @Override
   public int add(Parque parque) {
      int filas = -1;
      String sql = "INSERT INTO parque(nombre,extension,idCiudad) "
              + "VALUES (?,?,?)";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, parque.getNombre());
         ps.setDouble(2, parque.getExtension());
         ps.setLong(3, parque.getCiudad().getId());

         filas = ps.executeUpdate();
         ps.close();
         return filas;
      } catch (Exception e) {
         return -1;
      }
   }

   @Override
   public int updateParque(Parque parque) {
      int filas = -1;
      String sql = "UPDATE parque SET nombre = ?, extension = ?, idCiudad = ?"
              + " WHERE id = ?;";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, parque.getNombre());
         ps.setDouble(2, parque.getExtension());
         ps.setLong(3, parque.getCiudad().getId());
         ps.setLong(4, parque.getId());

         filas = ps.executeUpdate();
         ps.close();
         return filas;
      } catch (Exception e) {
         return -1;
      }
   }

   @Override
   public List<Parque> parquesPorNombreLike(Parque parque) {
      List<Parque> lista = new ArrayList<>();
      String sql = "SELECT * FROM parque WHERE nombre LIKE ?;";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, "%" + parque.getNombre() + "%");
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
            long idAux = rs.getLong("id");
            String nomAux = rs.getString("nombre");
            double extAux = rs.getDouble("extension");
            long ciuAux = rs.getLong("idCiudad");

//            Buscar la ciudad que le corresponde al parque
//             la ciudad es de un parque ya introducido, asumimos que la BD está bien.
            Ciudad a = new Ciudad();
            a.setId(ciuAux);
            a = FactoriaDAO.getCiudadDAO().findById(a);

//            Crear parque y añadir a lista
            Parque b = new Parque(idAux, nomAux, extAux, a);
            lista.add(b);
         }
         rs.close();
         ps.close();
         return lista;
      } catch (Exception e) {
         return null;
      }
   }

   @Override
   public int borrarPorCiudad(Ciudad ciudad) {
      int filas = -1;
      String sql = "DELETE FROM parque WHERE idCiudad = ?;";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setLong(1, ciudad.getId());
         filas = ps.executeUpdate();
         ps.close();
         return filas;
      } catch (Exception e) {
         return -1;
      }
   }

   public List<Parque> listParque() {
      List<Parque> lista = null;
      String sql = "SELECT * FROM parque;";
      try {
         Statement ps = conn.createStatement();
         ResultSet rs = ps.executeQuery(sql);
         lista = new ArrayList<>();
         while (rs.next()) {
            long idAux = rs.getLong("id");
            String nomAux = rs.getString("nombre");
            double extAux = rs.getDouble("extension");
            long ciuAux = rs.getLong("idCiudad");

//            Buscar la ciudad que le corresponde al parque
//             la ciudad es de un parque ya introducido, asumimos que la BD está bien.
            Ciudad a = new Ciudad();
            a.setId(ciuAux);
            a = FactoriaDAO.getCiudadDAO().findById(a);

//            Crear parque y añadir a lista
            Parque b = new Parque(idAux, nomAux, extAux, a);
            lista.add(b);
         }
         rs.close();
         ps.close();
         return lista;
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   public Parque getParqueByNombre(Parque parque) {
      Parque parAux = null;
      String sql = "SELECT * FROM parque WHERE nombre = ?;";
      try {
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, parque.getNombre());
         ResultSet rs = ps.executeQuery();
         if (rs.next()) {
            long idAux = rs.getLong("id");
            String nomAux = rs.getString("nombre");
            double extAux = rs.getDouble("extension");
            long ciuAux = rs.getLong("idCiudad");

            Ciudad ciu = new Ciudad();
            ciu.setId(ciuAux);
            ciu = FactoriaDAO.getCiudadDAO().findById(ciu);

            parAux = new Parque(idAux, nomAux, extAux, ciu);
         }
         rs.close();
         ps.close();
         return parAux;
      } catch (Exception e) {
         return parAux;
      }
   }
}
