/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablo.ud8_boletin_ej1.POJO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Benavent Martínez
 */
public class Ciudad {
//   Atributos 

   private long id;
   private String nombre;
   private List<Parque> listaParques;

//   Constructores
   public Ciudad() {
      super();
      listaParques = new ArrayList<>();
   }

   public Ciudad(long id, String nombre) {
      super();
      this.id = id;
      this.nombre = nombre;
      listaParques = new ArrayList<>();
   }

//   Getters y setters
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

   public List<Parque> getListaParques() {
      return listaParques;
   }

   public void setListaParques(List<Parque> listaParques) {
      this.listaParques = listaParques;
   }

   
//   toString
   @Override
   public String toString() {
      return "Ciudad{" + "id=" + id + ", nombre=" + nombre + '}';
   }

}
