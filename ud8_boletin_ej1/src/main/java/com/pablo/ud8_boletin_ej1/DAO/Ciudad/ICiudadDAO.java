/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pablo.ud8_boletin_ej1.DAO.Ciudad;

import com.pablo.ud8_boletin_ej1.POJO.Ciudad;
import com.pablo.ud8_boletin_ej1.POJO.Parque;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public interface ICiudadDAO {

   public int add(Ciudad ciudad);

   public int cantidadParquesPorCiudad(Ciudad ciudad);

   public List<Ciudad> ciudadesPorTamanyoParque(Parque parque);
}
