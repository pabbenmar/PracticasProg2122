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
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
         
         while(rs.next()){
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

}
