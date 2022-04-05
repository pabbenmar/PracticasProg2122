/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pablo.ud8_boletin_ej1.DAO.Parque;

import com.pablo.ud8_boletin_ej1.POJO.Ciudad;
import com.pablo.ud8_boletin_ej1.POJO.Parque;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public interface IParqueDAO {
        public List<Parque> parquesPorCiudad(Ciudad ciudad);
	public int add(Parque parque, Ciudad ciudad);
		//	si ciudad no existe informar
	public int updateParque();
	public List<Parque> parquesPorNombreLike(Parque parque);
	public int cantidadParquesPorCiudad(Ciudad ciudad);
	public int borrarPorCiudad(Ciudad ciudad);
}
