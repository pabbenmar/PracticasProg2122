/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loren.gestionventasv3.POJO;

import java.sql.Date;

/**
 *
 * @author Windows 10
 */
public class Pedido {
//   Atributos

   private Long id;
   private double total;
   private Date fecha;
   private Cliente cliente;
   private Comercial comercial;

//   Constructor
   public Pedido() {
      super();
   }

   public Pedido(Long id, double total, Date fecha, Cliente cliente, Comercial comercial) {
      super();
      this.id = id;
      this.total = total;
      this.fecha = fecha;
      this.cliente = cliente;
      this.comercial = comercial;
   }
   
//   Getters y setters

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public double getTotal() {
      return total;
   }

   public void setTotal(double total) {
      this.total = total;
   }

   public Date getFecha() {
      return fecha;
   }

   public void setFecha(Date fecha) {
      this.fecha = fecha;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public Comercial getComercial() {
      return comercial;
   }

   public void setComercial(Comercial comercial) {
      this.comercial = comercial;
   }
   
//   toString

   @Override
   public String toString() {
      return "Pedido{" + "id=" + id + ", total=" + total + ", fecha=" + fecha + ", cliente=" + cliente + ", comercial=" + comercial + '}';
   }
   
   

}
