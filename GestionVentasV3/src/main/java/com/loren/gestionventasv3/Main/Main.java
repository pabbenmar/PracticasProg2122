/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loren.gestionventasv3.Main;

import com.loren.gestionventasv3.DAO.ConexionBD;
import com.loren.gestionventasv3.DAO.FactoriaDAO;
import com.loren.gestionventasv3.POJO.Cliente;
import com.loren.gestionventasv3.POJO.Comercial;
import com.loren.gestionventasv3.POJO.Pedido;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author profesor
 */
public class Main {

   private static FactoriaDAO factoriaDAO;
   private static Scanner teclado = new Scanner(System.in);

   public static void main(String[] args) throws SQLException {

      int menuVentas = -1;
      try {
         while (menuVentas != 4) {
            menuVentas();
            menuVentas = Integer.parseInt(teclado.nextLine());
            switch (menuVentas) {
               // Gestion de clientes
               case 1: {

                  gestionCliente();

                  break;
               }
//               Gestion de comerciales
               case 2: {

                  gestionComercial();

                  break;
               }
//               Gestion de pedidos
               case 3: {

                  gestionPedido();
                  break;
               }
//                  Salida del programa
               case 4: {
                  ConexionBD.closeConnection();
                  break;
               }
               default: {
                  System.out.println("Opción incorrecta.");
                  break;
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         ConexionBD.closeConnection();
      }
   }
//            MENUS

   public static void menuVentas() {
      System.out.println("********************");
      System.out.println("Menú de ventas");
      System.out.println("********************");
      System.out.println("1.- Gestión de clientes.");
      System.out.println("2.- Gestión de comerciales.");
      System.out.println("3.- Gestión de pedidos.");
      System.out.println("4.- Salir.");
      System.out.print("Introduzca opcion: ");
   }

   public static void menuClientes() {
      System.out.println("********************");
      System.out.println("Menú de clientes");
      System.out.println("********************");
      System.out.println("1.- Alta de cliente.");
      System.out.println("2.- Baja de cliente.");
      System.out.println("3.- Actualizar cliente.");
      System.out.println("4.- Buscar cliente por ID.");
      System.out.println("5.- Buscar cliente por nombre.");
      System.out.println("6.- Buscar cliente por apellido con like.");
      System.out.println("7.- Listar clientes.");
      System.out.println("8.- Salir.");
      System.out.print("Introduzca opcion: ");
   }

   public static void menuComerciales() {
      System.out.println("********************");
      System.out.println("Menú de comerciales");
      System.out.println("********************");
      System.out.println("1.- Alta de comercial.");
      System.out.println("2.- Baja de comercial.");
      System.out.println("3.- Actualizar comercial.");
      System.out.println("4.- Buscar comercial por ID.");
      System.out.println("5.- Buscar comercial por nombre.");
      System.out.println("6.- Buscar comercial por apellido con like.");
      System.out.println("7.- Listar comerciales.");
      System.out.println("8.- Salir.");
      System.out.print("Introduzca opcion: ");
   }

   public static void menuPedidos() {
      System.out.println("********************");
      System.out.println("Menú de pedidos");
      System.out.println("********************");
      System.out.println("1.- Alta de pedido.");
      System.out.println("2.- Baja de pedido.");
      System.out.println("3.- Actualizar pedido.");
      System.out.println("4.- Buscar pedido por ID.");
      System.out.println("5.- Buscar pedido por ID de Cliente.");
      System.out.println("6.- Buscar pedido por Nombre de Cliente.");
      System.out.println("7.- Listar pedidos.");
      System.out.println("8.- Salir.");
      System.out.print("Introduzca opcion: ");
   }

//     SWITCH DE SUBMENUS
   private static void gestionCliente() {
      int menuCliente = -1;
      while (menuCliente != 8) {
         menuClientes();
         menuCliente = Integer.parseInt(teclado.nextLine());
         switch (menuCliente) {
            case 1: {

               addCliente();

               break;
            }
            // borrar cliente
            case 2: {

               mostrarClientes();
               borrarCliente();

               break;
            }
            // Actualizar cliente
            case 3: {

               mostrarClientes();
               actualizarCliente();

               break;
            }
            // Buscar cliente por id
            case 4: {

               BuscarClientePorID();

               break;
            }
            case 5: {

               BuscarClientePorNombre();

               break;
            }
            case 6: {

               BuscarClientePorApellido();

               break;
            }
            case 7: {
               mostrarClientes();
               break;
            }
            case 8: {
               break;
            }
            default: {
               System.out.println("Opción no válida");
            }
         }
      }
   }

   private static void gestionComercial() {
      int menuComercial = -1;
      while (menuComercial != 8) {
         menuComerciales();
         menuComercial = Integer.parseInt(teclado.nextLine());
         switch (menuComercial) {
            case 1: {

               addComercial();

               break;
            }
            // borrar comercial
            case 2: {

               mostrarComerciales();
               borrarComercial();

               break;
            }
            // Actualizar comercial
            case 3: {

               mostrarComerciales();
               actualizarComercial();

               break;
            }
            // Buscar comercial por id
            case 4: {

               BuscarComercialPorID();

               break;
            }
            case 5: {

               BuscarComercialPorNombre();

               break;
            }
            case 6: {

               BuscarComercialPorApellido();

               break;
            }
            case 7: {
               mostrarComerciales();
               break;
            }
            case 8: {
               break;
            }
            default: {
               System.out.println("Opción no válida");
            }
         }
      }
   }

   private static void gestionPedido() {
      int menuPedido = -1;
      while (menuPedido != 8) {
         menuPedidos();
         menuPedido = Integer.parseInt(teclado.nextLine());
         switch (menuPedido) {
            case 1: {

               addPedido();

               break;
            }
            // borrar comercial
            case 2: {

               mostrarPedidos();
               borrarPedido();

               break;
            }
            // Actualizar comercial
            case 3: {

               mostrarPedidos();
               actualizarPedido();

               break;
            }
            // Buscar comercial por id
            case 4: {

               BuscarPedidoPorID();

               break;
            }
            case 5: {

               BuscarPedidoPorIDCliente();

               break;
            }
            case 6: {

               BuscarPedidoPorNombreCliente();

               break;
            }
            case 7: {
               mostrarPedidos();
               break;
            }
            case 8: {
               break;
            }
            default: {
               System.out.println("Opción no válida");
            }
         }
      }
   }

//    APARTADO LOGICO CLIENTE
   private static void mostrarClientes() {
      List<Cliente> lista = factoriaDAO.getClienteDAO().getAll();
      if ((lista != null) && (!lista.isEmpty())) {
         System.out.println("********************");
         System.out.println("*** LISTA DE CLIENTES ****");
         System.out.println("********************");
         for (Cliente cliente : lista) {
            System.out.println(cliente.toString());
         }
      } else {
         System.out.println("No es posible mostrar la lista de clientes.");
      }
   }

   private static Cliente buscarCliente(String mensaje) {
      System.out.println(mensaje);
      Long idAux = Long.valueOf(teclado.nextLine());
      Cliente a = new Cliente();
      a.setId(idAux);
      a = factoriaDAO.getClienteDAO().findById(a);
      return a;
   }

   private static void addCliente() {
      System.out.println("Dime el nombre del cliente: ");
      String nomAux = teclado.nextLine();
      System.out.println("Dime el apellido1 del cliente: ");
      String ape1Aux = teclado.nextLine();
      System.out.println("Dime el apellido2 del cliente: ");
      String ape2Aux = teclado.nextLine();
      System.out.println("Dime la ciudad del cliente: ");
      String ciuAux = teclado.nextLine();
      System.out.println("Dime la categoria del cliente: ");
      int catAux = Integer.valueOf(teclado.nextLine());
      Cliente a = new Cliente();
      a.setNombre(nomAux);
      a.setApellido1(ape1Aux);
      a.setApellido2(ape2Aux);
      a.setCiudad(ciuAux);
      a.setCategoria(catAux);
      int i = factoriaDAO.getClienteDAO().add(a);
      if (i > 0) {
         System.out.println("Se ha insertado " + i + " clientes.");
      } else {
         System.out.println("No se han insertado el cliente.");
      }
   }

   private static void borrarCliente() {
      Cliente a = buscarCliente("Dime el id del cliente a borrar: ");
      if (a != null) {
         System.out.println("¿Estas seguro de borrar el cliente (S/N):");
         System.out.println(a.toString());
         String respuesta = teclado.nextLine();
         if (respuesta.equals("S")) {
            int i = factoriaDAO.getClienteDAO().delete(a);
            if (i > 0) {
               System.out.println("Se ha borrado " + i + " clientes.");
            } else {
               System.out.println("No se ha borrado el cliente.");
            }
         }
      }
   }

   private static void actualizarCliente() {
      Cliente a = buscarCliente("Dime el id del cliente que vas a modificar: ");
      if (a != null) {
         System.out.println("Dime el nombre del cliente: ");
         String nomAux = teclado.nextLine();
         System.out.println("Dime el apellido1 del cliente: ");
         String ape1Aux = teclado.nextLine();
         System.out.println("Dime el apellido2 del cliente: ");
         String ape2Aux = teclado.nextLine();
         System.out.println("Dime la ciudad del cliente: ");
         String ciuAux = teclado.nextLine();
         System.out.println("Dime la categoria del cliente: ");
         String catAux = teclado.nextLine();

         // Comprobamos que ha habido modificaciones
         a.setNombre((nomAux.trim().length() > 0) ? nomAux : a.getNombre());
         a.setApellido1((ape1Aux.trim().length() > 0) ? ape1Aux : a.getApellido1());
         a.setApellido2((ape2Aux.trim().length() > 0) ? ape2Aux : a.getApellido2());
         a.setCiudad((ciuAux.trim().length() > 0) ? ciuAux : a.getCiudad());
         a.setCategoria((catAux.trim().length() > 0) ? Integer.valueOf(catAux) : a.getCategoria());

         int i = factoriaDAO.getClienteDAO().update(a);
         if (i > 0) {
            System.out.println("Se ha actualizado " + i + " clientes.");
         } else {
            System.out.println("No se ha actualizado el cliente.");
         }
      }
   }

   private static void BuscarClientePorID() {
      Cliente a = buscarCliente("Dime el id del cliente: ");
      if (a == null) {
         System.out.println("Cliente no encontrado");
      } else {
         System.out.println(a.toString());
      }
   }

   private static void BuscarClientePorNombre() {
      System.out.println("Dime el nombre del cliente: ");
      String nomAux = teclado.nextLine();
      Cliente a = new Cliente();
      a.setNombre(nomAux);
      List<Cliente> lista = factoriaDAO.getClienteDAO().findByNombre(a);
      if ((lista != null) && (!lista.isEmpty())) {
         System.out.println("********************");
         System.out.println("*** LISTA DE CLIENTES POR NOMBRE ****");
         System.out.println("********************");
         for (Cliente cliente : lista) {
            System.out.println(cliente.toString());
         }
      } else {
         System.out.println("No es posible mostrar la lista de clientes.");
      }
   }

   private static void BuscarClientePorApellido() {
      System.out.println("Dime el apellido del cliente: ");
      String ape1Aux = teclado.nextLine();
      Cliente a = new Cliente();
      a.setApellido1(ape1Aux);
      List<Cliente> lista = factoriaDAO.getClienteDAO().findByApellido(a);
      if ((lista != null) && (!lista.isEmpty())) {
         System.out.println("********************");
         System.out.println("*** LISTA DE CLIENTES POR APELLIDO ****");
         System.out.println("********************");
         for (Cliente cliente : lista) {
            System.out.println(cliente.toString());
         }
      } else {
         System.out.println("No es posible mostrar la lista de clientes.");
      }
   }

//   APARTADO LOGICO COMERCIAL
   private static void mostrarComerciales() {
      List<Comercial> lista = factoriaDAO.getComercialDAO().getAll();
      if ((lista != null) && (!lista.isEmpty())) {
         System.out.println("****************************");
         System.out.println("*** LISTA DE COMERCIALES ***");
         System.out.println("****************************");
         for (Comercial comercial : lista) {
            System.out.println(comercial.toString());
         }
      } else if (lista != null) {
         System.out.println("No hay comerciales en la BD.");
      } else {
         System.out.println("No es posible mostrar la lista de comerciales.");
      }
   }

   private static Comercial buscarComercial(String mensaje) {
      System.out.println(mensaje);
      Long idAux = Long.valueOf(teclado.nextLine());
      Comercial a = new Comercial();
      a.setId(idAux);
      a = factoriaDAO.getComercialDAO().findById(a);
      return a;
   }

   private static void addComercial() {
      System.out.println("Dime el nombre del comercial: ");
      String nomAux = teclado.nextLine();
      System.out.println("Dime el apellido1 del comercial: ");
      String ape1Aux = teclado.nextLine();
      System.out.println("Dime el apellido2 del comercial: ");
      String ape2Aux = teclado.nextLine();
      System.out.println("Dime la comision del comercial: ");
      float comAux = Float.valueOf(teclado.nextLine());
      Comercial a = new Comercial();
      a.setNombre(nomAux);
      a.setApellido1(ape1Aux);
      a.setApellido2(ape2Aux);
      a.setComision(comAux);
      int i = factoriaDAO.getComercialDAO().add(a);
      if (i > 0) {
         System.out.println("Se ha insertado " + i + " comerciales.");
      } else {
         System.out.println("No se han insertado el comercial.");
      }
   }

   private static void borrarComercial() {
      Comercial a = buscarComercial("Dime el id del comercial a borrar: ");
      if (a != null) {
         System.out.println("¿Estas seguro de borrar el comercial (S/N):");
         System.out.println(a.toString());
         String respuesta = teclado.nextLine();
         if (respuesta.equals("S")) {
            int i = factoriaDAO.getComercialDAO().delete(a);
            if (i > 0) {
               System.out.println("Se ha borrado " + i + " comerciales.");
            } else {
               System.out.println("No se ha borrado el comercial.");
            }
         }
      }
   }

   private static void actualizarComercial() {
      Comercial a = buscarComercial("Dime el id del comercial que vas a modificar: ");
      if (a != null) {
         System.out.println("Dime el nombre del comercial: ");
         String nomAux = teclado.nextLine();
         System.out.println("Dime el apellido1 del comercial: ");
         String ape1Aux = teclado.nextLine();
         System.out.println("Dime el apellido2 del comercial: ");
         String ape2Aux = teclado.nextLine();
         System.out.println("Dime la comision del comercial: ");
         String comAux = teclado.nextLine();

         // Comprobamos que ha habido modificaciones
         a.setNombre((nomAux.trim().length() > 0) ? nomAux : a.getNombre());
         a.setApellido1((ape1Aux.trim().length() > 0) ? ape1Aux : a.getApellido1());
         a.setApellido2((ape2Aux.trim().length() > 0) ? ape2Aux : a.getApellido2());
         a.setComision((comAux.trim().length() > 0) ? Float.valueOf(comAux) : a.getComision());

         int i = factoriaDAO.getComercialDAO().update(a);
         if (i > 0) {
            System.out.println("Se ha actualizado " + i + " comercialss.");
         } else {
            System.out.println("No se ha actualizado el comercial.");
         }
      }
   }

   private static void BuscarComercialPorID() {
      Comercial a = buscarComercial("Dime el id del comercial: ");
      if (a == null) {
         System.out.println("Comercial no encontrado");
      } else {
         System.out.println(a.toString());
      }
   }

   private static void BuscarComercialPorNombre() {
      System.out.println("Dime el nombre del comercial: ");
      String nomAux = teclado.nextLine();
      Comercial a = new Comercial();
      a.setNombre(nomAux);
      List<Comercial> lista = factoriaDAO.getComercialDAO().findByNombre(a);
      if ((lista != null) && (!lista.isEmpty())) {
         System.out.println("***************************************");
         System.out.println("*** LISTA DE COMERCIALES POR NOMBRE ***");
         System.out.println("***************************************");
         for (Comercial comercial : lista) {
            System.out.println(comercial.toString());
         }
      } else {
         System.out.println("No es posible mostrar la lista de comerciales.");
      }
   }

   private static void BuscarComercialPorApellido() {
      System.out.println("Dime el apellido del comercial: ");
      String ape1Aux = teclado.nextLine();
      Comercial a = new Comercial();
      a.setApellido1(ape1Aux);
      List<Comercial> lista = factoriaDAO.getComercialDAO().findByApellido(a);
      if ((lista != null) && (!lista.isEmpty())) {
         System.out.println("**************************************");
         System.out.println("*** LISTA DE CLIENTES POR APELLIDO ***");
         System.out.println("**************************************");
         for (Comercial comercial : lista) {
            System.out.println(comercial.toString());
         }
      } else {
         System.out.println("No es posible mostrar la lista de comerciales.");
      }
   }

   
//    APARTADO LOGICA PEDIDOS
   
   private static void mostrarPedidos() {
      List<Pedido> lista = factoriaDAO.getPedidoDAO().getAll();
      if ((lista != null) && (!lista.isEmpty())) {
         System.out.println("****************************");
         System.out.println("*** LISTA DE PEDIDOS ***");
         System.out.println("****************************");
         for (Pedido pedido : lista) {
            System.out.println(pedido.toString());
         }
      } else if (lista != null) {
         System.out.println("No hay pedidoes en la BD.");
      } else {
         System.out.println("No es posible mostrar la lista de pedidos.");
      }
   }

   private static void addPedido() {
      int filas;
      System.out.println("Dime el total del pedido: ");
      String totAux = teclado.nextLine();
      System.out.println("Dime la direccion del pedido: ");
      String fecAux = teclado.nextLine();

      System.out.println("Dime el cliente del pedido: ");
      String cliAux = teclado.nextLine();
      System.out.println("Dime el comercial del pedido;");
      String comAux = teclado.nextLine();

//      Validar cliente
      Cliente cliente = new Cliente();
      cliente.setId(Long.valueOf(cliAux));
      cliente = FactoriaDAO.getClienteDAO().findById(cliente);

      if (cliente == null) {
         System.out.println("No se ha encontrado el cliente.");
         return;
      }

      Comercial comercial = new Comercial();
      comercial.setId(Long.valueOf(comAux));
      comercial = FactoriaDAO.getComercialDAO().findById(comercial);

      if (comercial == null) {
         System.out.println("No se ha encontrado el comercial.");
         return;
      }

      Pedido pedido = new Pedido();
      pedido.setTotal(Double.valueOf(totAux));
      pedido.setFecha(Date.valueOf(fecAux));
      pedido.setCliente(cliente);
      pedido.setComercial(comercial);

      filas = FactoriaDAO.getPedidoDAO().add(pedido);
      if (filas > -1) {
         System.out.println("Se han insertado " + filas + " filas.");
      } else {
         System.out.println("No se ha podido insertar.");
      }

   }

   private static void borrarPedido() {
      mostrarPedidos();
      Pedido ped = new Pedido();
      System.out.println("Dime el id del pedido a borrar: ");
      Long idAux = Long.valueOf(teclado.nextLine());
      ped.setId(idAux);
      
      
   }

   private static void actualizarPedido() {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   }

   private static void BuscarPedidoPorID() {
      Pedido ped = new Pedido();
      System.out.println("Dime el id del pedido a buscar: ");
      Long idAux = Long.valueOf(teclado.nextLine());
      ped.setId(idAux);
      
      ped = FactoriaDAO.getPedidoDAO().findById(ped);
      
      if (ped != null) {
         System.out.println(ped.toString());
      }else{
         System.out.println("No se ha encontrado un pedido con esa id");
      }
   }

   private static void BuscarPedidoPorIDCliente() {
      throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   }

   private static void BuscarPedidoPorNombreCliente() {
      System.out.println("Dime el nombre del cliente: ");
      String nomAux = teclado.nextLine();
      Cliente a = new Cliente();
      a.setNombre(nomAux);
      List<Cliente> lista = factoriaDAO.getClienteDAO().findByNombre(a);

      Cliente b = lista.get(0);

      if (b == null) {
         System.out.println("No se ha encontrado el cliente");
      } else {
         FactoriaDAO.getPedidoDAO().loadPedidosByNombreCliente(lista.get(0));
         for (Pedido pedido : b.getListaPedidos()) {
            System.out.println(pedido.toString());
         }
      }

   }

}
