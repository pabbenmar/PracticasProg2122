/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablo.ud8_boletin_ej1.main;

import com.pablo.ud8_boletin_ej1.DAO.ConexionBD;
import com.pablo.ud8_boletin_ej1.DAO.FactoriaDAO;
import com.pablo.ud8_boletin_ej1.POJO.Ciudad;
import java.util.List;
import com.pablo.ud8_boletin_ej1.POJO.Parque;
import java.util.Scanner;

/**
 *
 * @author Pablo Benavent Martínez
 */
public class Main {

   final static Scanner SCN = new Scanner(System.in);

   public static void main(String[] args) {

      switchMenu();

      cerrarPrograma();
   }

   private static void menu() {
      System.out.println("SISTEMA DE GESTION DE PARQUES");
      System.out.println("-----------------------------");
      System.out.println("------- MENU GENERAL -------");
      System.out.println("**** Gestion de parques *****");
      System.out.println("1.- Añadir parque");
      System.out.println("2.- Listar parques por nombre de parque");
      System.out.println("3.- Modificar parque");
      System.out.println("4.- Borrar parques por ciudad");
      System.out.println("5.- Listar parques por ciudad");
      System.out.println("**** Gestion de ciudades ****");
      System.out.println("6.- Añadir ciudad");
      System.out.println("7.- Listar ciudades con parques de extension mayor a");
      System.out.println("8.- Numero de parques que tiene una ciudad.");
      System.out.println("9.- Salir.");
      System.out.print("Elija una opcion:");

   }

   private static void switchMenu() {
      int opcionMenu;
      do {
         menu();
         opcionMenu = Integer.valueOf(SCN.nextLine());
         switch (opcionMenu) {
            case 1: // add parque
               addParque();
               break;
            case 2: // listar por nombre
               listarPorNombre();
               break;
            case 3: // modificar parque
               modificarParque();
               break;
            case 4: // borrar por ciudad
               borrarPorCiudad();
               break;
            case 5: // listar por ciudad
               listarPorCiudad();
               break;
            case 6: // add ciudad
               addCiudad();
               break;
            case 7: // listar por extension de parque
               listarCiudadPorExtension();
               break;
            case 8: // contar parques en ciudad
               contarParquesEnCiudad();
               break;
            case 9: // salir
               System.out.println("Saliendo... .. .");
               break;
            default:
               System.out.println("Opcion incorrecta.");
         }
      } while (opcionMenu != 9);
   }

   private static void cerrarPrograma() {
      ConexionBD.closeConnection();
   }

   private static void addParque() {
      System.out.println("***********************");
      System.out.println("**** Añadir parque ****");
      System.out.println("***********************");
      System.out.print("Introduzca nombre del parque: ");
      String nomAux = SCN.nextLine();
      System.out.print("Introduzca extension del parque: ");
      String extAux = SCN.nextLine();
      Ciudad ciudad = null;
      while (ciudad == null) { // Control de existencia de la ciudad
         System.out.print("Introduzca ciudad a la que pertenece el parque: ");
         Ciudad aux = new Ciudad();
         aux.setNombre(SCN.nextLine());
         ciudad = FactoriaDAO.getCiudadDAO().findByName(aux);
         if (ciudad == null) {
            System.out.print("Ciudad no encontrada, desea intentarlo de nuevo (S/N)?");
            if (SCN.nextLine().toUpperCase().charAt(0) == 'N') {
               return; // Si la persona no quiere continuar, cerrar el metodo.
            }
         }
      }
      Parque parAux = new Parque(0, nomAux, Double.valueOf(extAux), ciudad);
      int filas = FactoriaDAO.getParqueDAO().add(parAux);
      System.out.println("Se han creado " + filas + " filas.");
   }

   private static void listarPorNombre() {
      System.out.println("***********************************");
      System.out.println("**** Listar parques por nombre ****");
      System.out.println("***********************************");
      System.out.println("Introduzca en nombre del parque a buscar");
      System.out.print("(nombre parcial o total): ");
      Parque parAux = new Parque();
      parAux.setNombre(SCN.nextLine());

      List<Parque> lista = FactoriaDAO.getParqueDAO().parquesPorNombreLike(parAux);

      if (lista == null) {
         System.out.println("No se ha podido realizar la lista");
      } else if (lista.isEmpty()) {
         System.out.println("No se encuentran parques con ese nombre");
      } else {
         System.out.println("Lista de parques:");
         for (Parque parque : lista) {
            System.out.println(parque.toString());
         }
      }
   }

   private static void modificarParque() {
      System.out.println("*****************************");
      System.out.println("**** Modificar un parque ****");
      System.out.println("*****************************");
      List<Parque> listaParques = FactoriaDAO.getParqueDAO().listParque();
      if(listaParques == null){
         System.out.println("No se ha podido realizar la operacion");
         return;
      }else if(listaParques.isEmpty()){
         System.out.println("No hay parques registrados en el sistema.");
         return;
      }else{
         System.out.println("Listado de parques: ");
         for (Parque parque : listaParques) {
            System.out.println(parque.toString());
         }
      }
//      Solicitar parque y comprobar que existe
      System.out.print("Elija el parque a modificar (por nombre): ");
      Parque aModificar = new Parque(0, SCN.nextLine(), 0, null);
      aModificar = FactoriaDAO.getParqueDAO().getParqueByNombre(aModificar);
      if(aModificar == null){
         System.out.println("Parque no encontrado, volviendo al menu.");
         return;
      }
//         Solicitar nuevos valores
         System.out.println("Introduzca los nuevos datos del parque...");
         System.out.print("Introduzca nombre: ");
         String nomAux = SCN.nextLine();
         System.out.print("Introduzca extensión: ");
         String extAux = SCN.nextLine();
         System.out.print("Introduzca nombre de la ciudad: ");
         String ciuAux = SCN.nextLine();
//         Comprobar ciudad correcta
         Ciudad ciu = new Ciudad(0, ciuAux);
         ciu = FactoriaDAO.getCiudadDAO().findByName(ciu);
         if(ciu == null && !ciuAux.trim().isBlank()){
            System.out.println("Ciudad no encontrada, volviendo al menú.");
            return;
         }
//         Establecer nuevos valores
         aModificar.setNombre(nomAux.trim().isEmpty()?aModificar.getNombre():nomAux);
         aModificar.setExtension(extAux.trim().isEmpty()?aModificar.getExtension():Double.valueOf(extAux));
         aModificar.setCiudad(ciuAux.trim().isEmpty()?aModificar.getCiudad():ciu);
         
//         Hacer el update
         int filas = FactoriaDAO.getParqueDAO().updateParque(aModificar);
         System.out.println("Se han modificado " + filas + " parques.");
   }

   private static void borrarPorCiudad() {
      System.out.println("************************************************");
      System.out.println("**** Borrar todos los parques de una ciudad ****");
      System.out.println("************************************************");
      System.out.println("Listado de ciudades:");
      List<Ciudad> lista = FactoriaDAO.getCiudadDAO().ListarCiudades();
      if (lista == null) {
         System.out.println("No se ha podido realizar la operacion");
         return;
      } else if (lista.isEmpty()) {
         System.out.println("No hay ciudades registradas");
         return;
      } else {
         for (Ciudad ciudad : lista) {
            System.out.println(ciudad.toString());
         }
      }
      System.out.println("-------------------");
      System.out.print("Elija una ciudad: ");
      Ciudad ciuAux = new Ciudad(0, SCN.nextLine());
      ciuAux = FactoriaDAO.getCiudadDAO().findByName(ciuAux);
      if (ciuAux == null) {
         System.out.println("La ciudad no existe");
         return;
      }
      long numABorrar = FactoriaDAO.getCiudadDAO().cantidadParquesPorCiudad(ciuAux);
      System.out.printf("Se van a borrar %d parques, desea continuar (S/N)?:", numABorrar);
      if (SCN.nextLine().toUpperCase().charAt(0) == 'S') {
         int filas = FactoriaDAO.getParqueDAO().borrarPorCiudad(ciuAux);
         System.out.printf("Se han borrado %d parques.%n", filas);
      } else {
         System.out.println("Operacion cancelada.");
      }
   }

   private static void listarPorCiudad() {
      System.out.println("************************************************");
      System.out.println("**** Listar todos los parques de una ciudad ****");
      System.out.println("************************************************");
      System.out.println("Listado de ciudades:");
      List<Ciudad> lista = FactoriaDAO.getCiudadDAO().ListarCiudades();
      if (lista == null) {
         System.out.println("No se ha podido realizar la operacion");
         return;
      } else if (lista.isEmpty()) {
         System.out.println("No hay ciudades registradas");
         return;
      } else {
         for (Ciudad ciudad : lista) {
            System.out.println(ciudad.toString());
         }
      }
      System.out.println("-------------------");
      System.out.print("Elija una ciudad: ");
      Ciudad ciuAux = new Ciudad(0, SCN.nextLine());
      ciuAux = FactoriaDAO.getCiudadDAO().findByName(ciuAux);
      if (ciuAux == null) {
         System.out.println("La ciudad no existe");
         return;
      }
      FactoriaDAO.getCiudadDAO().parquesPorCiudad(ciuAux);
      if (!ciuAux.getListaParques().isEmpty()) {
         System.out.printf("Lista de parques en %s:%n", ciuAux.getNombre());
         for (Parque parque : ciuAux.getListaParques()) {
            System.out.println(parque.toString());
         }
      } else {
         System.out.println("La ciudad no tiene parques.");
      }
   }

   private static void addCiudad() {
      System.out.println("***********************");
      System.out.println("**** Añadir ciudad ****");
      System.out.println("***********************");
      System.out.print("Introduzca nombre de la ciudad: ");
      String nomAux = SCN.nextLine();
      Ciudad ciuAux = new Ciudad(-1, nomAux);

      int filas = FactoriaDAO.getCiudadDAO().add(ciuAux);
      if (filas < 0) {
         System.out.println("Error al realizar la operacion");
      } else if (filas == 0) {
         System.out.println("No se han modificado los datos");
      } else {
         System.out.printf("Se han insertado %d ciudades.%n", filas);
      }
   }

   private static void listarCiudadPorExtension() {
      System.out.println("**********************************************************");
      System.out.println("**** Listar ciudades con parques con parques extensos ****");
      System.out.println("**********************************************************");
      System.out.print("Introduzca la extension minima a tener en cuenta: ");
      double extAux = Double.valueOf(SCN.nextLine());
      Parque parqAux = new Parque();
      parqAux.setExtension(extAux);
      List<Ciudad> lista = FactoriaDAO.getCiudadDAO().ciudadesPorTamanyoParque(parqAux);
      if(lista == null){
         System.out.println("No se ha podido realizar la operacion");
      }else if (lista.isEmpty()){
         System.out.printf("No hay ciudades que contengan parques con extension de mas de %0.2f.%n",extAux);
      }else{
         System.out.printf("Ciudades con parques de mas de %.2f:%n",extAux);
         for (Ciudad ciudad : lista) {
            System.out.println(ciudad.toString());
         }
      }
      
   }

   private static void contarParquesEnCiudad() {
      System.out.println("*****************************************");
      System.out.println("**** Numero de parques en una ciudad ****");
      System.out.println("*****************************************");
      System.out.println("Listado de ciudades:");
      List<Ciudad> lista = FactoriaDAO.getCiudadDAO().ListarCiudades();
      if (lista == null) {
         System.out.println("No se ha podido realizar la operacion");
         return;
      } else if (lista.isEmpty()) {
         System.out.println("No hay ciudades registradas");
         return;
      } else {
         for (Ciudad ciudad : lista) {
            System.out.println(ciudad.toString());
         }
      }
      System.out.println("-------------------");
      System.out.print("Elija una ciudad: ");
      Ciudad ciuAux = new Ciudad(0, SCN.nextLine());
      ciuAux = FactoriaDAO.getCiudadDAO().findByName(ciuAux);
      if (ciuAux == null) {
         System.out.println("La ciudad no existe");
         return;
      }
      long numABorrar = FactoriaDAO.getCiudadDAO().cantidadParquesPorCiudad(ciuAux);
      System.out.printf("La ciudad %s tiene %d parques.%n", ciuAux.getNombre(), numABorrar);
   }

}
