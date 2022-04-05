/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablo.ud8_boletin_ej1.POJO;

/**
 *
 * @author Pablo Benavent Martínez
 */
public class Parque {
//    Atributos
     private long id;
     private String nombre;
     private double extension;
     private Ciudad ciudad;
     
//     Constructores 

    public Parque() {
        super();
    }

   public Parque(long id, String nombre, double extension, Ciudad ciudad) {
      super();
      this.id = id;
      this.nombre = nombre;
      this.extension = extension;
      this.ciudad = ciudad;
   }

    
    
//    Getter y setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getExtension() {
        return extension;
    }

    public void setExtension(double extension) {
        this.extension = extension;
    }

   public Ciudad getCiudad() {
      return ciudad;
   }

   public void setCiudad(Ciudad ciudad) {
      this.ciudad = ciudad;
   }
    
    
    
//    toString

   @Override
   public String toString() {
      return "Parque{" + "id=" + id + ", nombre=" + nombre + ", extension=" + extension + ", ciudad=" + ciudad + '}';
   }

   
    
}
