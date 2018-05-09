/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomarpedido;

import java.util.List;
import java.util.Scanner;
import modelos.TamanioPizza;
import modelos.TipoPizza;
import modelos.VariedadPizza;
import tienda.ControladorVistas;

/**
 *
 * @author utku36
 */
public class VistaPedido implements ContratoVistaPedido {
    
    private final ContratoPresentadorPedido presentador;
    private final ControladorVistas controlador;
    
    public VistaPedido (ControladorVistas controlador){
        this.controlador = controlador;
        this.presentador=new PresentadorPedido(this);
        this.presentador.iniciar();
        
}
    
    @Override
    public void mostrarSeleccionVariedadPizza(){
        Scanner teclado=new Scanner(System.in);
        clearConsole();
        System.out.println("\t"+"¡Tipo Pizza!"+"\n"+
                "Ingrese una de las siguientes opciones: "+"\n"+
                "-1) Para regresar al menu principal"+"\n"+
                "NRO) El numero del tipo de pizza para seleccionar el tipo."+"\n");
        int opcion=teclado.nextInt();
        presentador.procesarTipoPizzaIngresado(opcion);
    }
    
    @Override
    public void mostrarOPcionErronea(){
        this.clearConsole();
        System.out.println("La opcion ingresada no es correcta.");
        }
    
    private void clearConsole() {
        System.out.print("\033[H\033[2J");
/*
    try {
      final String os = System.getProperty("os.name");
      if (os.contains("Windows")) {
          Runtime.getRuntime().exec("cls");
      } else {
          Runtime.getRuntime().exec("clear");
      }
    } catch (final Exception e) {
        System.out.println("something went wrong :(");
    }
*/
  }

    @Override
    public void irMenuPrincipal() {
        this.controlador.lanzarMenuPrincipal();
    }

    @Override
    public void mostrarSeleccionCoccion() {
        Scanner teclado=new Scanner(System.in);
        clearConsole();
        System.out.println("\t"+"¡COCCION!"+"\n"+
                "Ingrese una de las siguientes opciones: "+"\n"+
                "-1) Para regresar al menu principal"+"\n"+
                "-2) Para cambiar el tipo de pizza"+"\n"+
                "NRO) El numero del tipo de coccion para seleccionar el tipo de coccion."+"\n");
        int opcion=teclado.nextInt();
        presentador.procesarCoccionSeleccionada(opcion);
    }
    
    @Override
    public void mostrarSeleccionarTamanioPizza(){
        Scanner teclado=new Scanner(System.in);
        clearConsole();
        System.out.println("\t"+"¡Tamanio!"+"\n"+
                "Ingrese una de las siguientes opciones: "+"\n"+
                "-1) Para regresar al menu principal"+"\n"+
                "-2) Para cambiar el tipo de coccion"+"\n"+
                "NRO) El numero del tipo de tamanio para seleccionar el tipo de tamanio."+"\n");
        int opcion=teclado.nextInt();
        presentador.procesarTamanioSeleccionado(opcion);  
    }
    
    @Override
    public void PedirCantidad (){
        Scanner teclado=new Scanner(System.in);
        clearConsole();
        System.out.println("Cuantas pizzas de este tipo quiere?");
        int opcion = teclado.nextInt();
        presentador.procesarCantidades(opcion);
    }
    
    @Override
    public void confirmacion(){
        Scanner teclado=new Scanner(System.in);
        int opcion;
        clearConsole();
        int variedad= presentador.getCodigoTipoPizza();
        int coccion= presentador.getCodigoCoccion();
        int tamanio= presentador.getCodigoTamanio();
        System.out.println("Su eleccion fue:");
        System.out.println(presentador.getCantidad()+" pizzas de "+
                           presentador.obtenerVariedades().get(variedad).getNombre()+
                           " de tamaño "+ presentador.obtenerTamanioPizza().get(tamanio).getNombre()+
                           " hecha con "+ presentador.obtenerTiposCoccion().get(coccion).getNombre());
        System.out.println("Desea confirmar su eleccion?");
        System.out.println("1)Si");
        System.out.println("2)No");
        opcion = teclado.nextInt();
        presentador.procesarConfirmacion(opcion);
        
    }

    @Override
    public void mostrarVariedadesDisponibles() {
        List<VariedadPizza> variedades = this.presentador.obtenerVariedades();
        
        for (int index = 0; index < variedades.size(); index++) {
            System.out.println("Codigo: " + index + "  -> " + "Variedad: " + variedades.get(index).getNombre());
            
        }
    }

    @Override
    public void mostrarTiposCoccionDisponibles() {
        List<TipoPizza> cocciones = this.presentador.obtenerTiposCoccion();
        
        for (int index = 0; index < cocciones.size(); index++) {
            System.out.println("Codigo: " + index + "  -> " + "Coccion: " + cocciones.get(index).getNombre());
            
        }
    }
    
    public void mostrarTamaniosDisponibles(){
        List<TamanioPizza> tamanios = this.presentador.obtenerTamanioPizza();
        
        for (int index = 0; index < tamanios.size(); index++) {
            System.out.println("Codigo: " + index + "  -> " + "Tamanio: " + tamanios.get(index).getNombre());
           
        }
    }
}
