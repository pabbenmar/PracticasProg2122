/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablo.ud8_boletin_ej1.DAO;

import com.pablo.ud8_boletin_ej1.DAO.Parque.ParqueDAO;
import com.pablo.ud8_boletin_ej1.DAO.Ciudad.CiudadDAO;

/**
 *
 * @author Windows 10
 */
public class FactoriaDAO {
   private static CiudadDAO ciudadDAO= null;
   private static ParqueDAO parqueDAO= null;
   
   public static CiudadDAO getCiudadDAO(){
      if (ciudadDAO == null){
         ciudadDAO = new CiudadDAO();
      }
      return ciudadDAO;
   }
   
   public static ParqueDAO getParqueDAO(){
      if (parqueDAO == null){
         parqueDAO = new ParqueDAO();
      }
      return parqueDAO;
   }
}
