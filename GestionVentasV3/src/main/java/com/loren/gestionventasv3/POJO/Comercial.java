/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loren.gestionventasv3.POJO;

/**
 *
 * @author Windows 10
 */
public class Comercial {
//   Atributos
   private long id;
   private String nombre;
   private String apellido1;
   private String apellido2;
   private float comision;

//   Constructores
   public Comercial() {
      super();
   }

   public Comercial(long id, String nombre, String apellido1, String apellido2, float comision) {
      super();
      this.id = id;
      this.nombre = nombre;
      this.apellido1 = apellido1;
      this.apellido2 = apellido2;
      this.comision = comision;
   }

   public String getApellido1() {
      return apellido1;
   }

   public void setApellido1(String apellido1) {
      this.apellido1 = apellido1;
   }

   public String getApellido2() {
      return apellido2;
   }

   public void setApellido2(String apellido2) {
      this.apellido2 = apellido2;
   }

   public float getComision() {
      return comision;
   }

//  Getters y Setters
   public void setComision(float comision) {
      this.comision = comision;
   }

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

//   toString

   @Override
   public String toString() {
      return "Comercial{" + "id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", comision=" + comision + '}';
   }

   
}
