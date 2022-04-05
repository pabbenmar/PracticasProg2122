/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablo.ud8_boletin_ej1.DAO;

/**
 *
 * @author Pablo Benavent Martínez
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author profesor
 */
public class ConexionBD {
    
    private final String USER = "pablo";
    private final String PASSWORD = "1daw";
    private final String URL = 
            "jdbc:mysql://localhost:3306/parques";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection conexion = null;
    
    // Cambio la visibilidad para controlar la construccion
    private ConexionBD(){

        try{
            // Carga del driver
            Class.forName(DRIVER);
            // Establecer la conexión con la BD
            conexion = 
                    DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // Mi propio constructor
    public static Connection getConnection() {
        if(conexion == null){
            new ConexionBD();
        }
        return conexion;

    }
    
    public static void closeConnection(){
        try{
            conexion.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
