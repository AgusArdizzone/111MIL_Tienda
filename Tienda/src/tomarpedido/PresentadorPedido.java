/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomarpedido;

import java.util.List;
import modelos.DetallePedido;
import modelos.Pedido;
import modelos.TipoPizza;
import modelos.VariedadPizza;
import modelos.TamanioPizza;
import tomarpedido.proveedores.FalsoProveedorTomaPedido;
import tomarpedido.proveedores.ProveedorTomaPedido;


/**
 *
 * @author utku36
 */
public class PresentadorPedido implements ContratoPresentadorPedido{
    
    private final ContratoVistaPedido vista;
    private final ProveedorTomaPedido proveedorTomaPedido;
    private int codigoTipoPizza;
    private int codigoCoccion;
    private int codigoTamanio;
    private int cantidad;
    private Pedido miPedido;
    private List<DetallePedido> detalles;

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public int getCodigoCoccion() {
        return codigoCoccion;
    }

    @Override
    public int getCodigoTamanio() {
        return codigoTamanio;
    }

    @Override
    public int getCodigoTipoPizza() {
        return codigoTipoPizza;
    }
    
    
    public PresentadorPedido(ContratoVistaPedido vista) {
        this.vista = vista;
        this.proveedorTomaPedido = new FalsoProveedorTomaPedido();
    }
    
    
    @Override
    public void procesarTipoPizzaIngresado(int op){
        if(comprobacionOpcion(obtenerVariedades().size(),op)){
            switch(op){
            case -1:
                this.vista.irMenuPrincipal();
                break;
            default:
                this.codigoTipoPizza = op;
                this.vista.mostrarTiposCoccionDisponibles();
                this.vista.mostrarSeleccionCoccion();
                break;   
        }
        }else{
            this.vista.mostrarVariedadesDisponibles();
            this.vista.mostrarSeleccionVariedadPizza();
        }
        
    }
    @Override
    public void iniciar(){
        this.vista.mostrarVariedadesDisponibles();
        this.vista.mostrarSeleccionVariedadPizza();
    }

    @Override
    public void procesarCoccionSeleccionada(int op) {
        if(comprobacionOpcion(obtenerTiposCoccion().size(),op)){
             switch(op){
            case -1:
                this.vista.irMenuPrincipal();
                break;
            case -2:
                this.vista.mostrarVariedadesDisponibles();
                this.vista.mostrarSeleccionVariedadPizza();
                break;
            default:
                this.codigoCoccion = op;
                this.vista.mostrarTamaniosDisponibles();
                this.vista.mostrarSeleccionarTamanioPizza();
                break;
        }
        }else{
            this.vista.mostrarTiposCoccionDisponibles();
            this.vista.mostrarSeleccionCoccion();
        }
        
    }
    
    @Override
    public void procesarTamanioSeleccionado(int op) {
        if(comprobacionOpcion(obtenerTamanioPizza().size(), op)){
            switch(op){
            case -1:
                this.vista.irMenuPrincipal();
                break;
            case -2:
                this.vista.mostrarTiposCoccionDisponibles();
                this.vista.mostrarSeleccionCoccion();
                break;
            default:
                this.codigoTamanio = op;
                this.vista.PedirCantidad();
                break;
        }
        }else{
            this.vista.mostrarTamaniosDisponibles();
            this.vista.mostrarSeleccionarTamanioPizza();
        }
        
    }
    
    @Override
    public void procesarCantidades(int op){
        switch(op){
            case 0:
                this.vista.mostrarTamaniosDisponibles();
                this.vista.mostrarSeleccionarTamanioPizza();
                break;
            default:
                cantidad= op;
                this.vista.confirmacion();
                break;
        }
        
    }
    
    @Override
    public void procesarConfirmacion(int op){
        switch(op){
            case 1:
                
                break;
            case 2:
                this.vista.irMenuPrincipal();
                break;
            default:
                this.vista.confirmacion();
                break;
        }
    }

    @Override
    public List<VariedadPizza> obtenerVariedades() {
        return this.proveedorTomaPedido.obtenerVariedades();
    }

    @Override
    public List<TipoPizza> obtenerTiposCoccion() {
        return this.proveedorTomaPedido.obtenerTipos();
    }
    
    @Override
    public List<TamanioPizza> obtenerTamanioPizza(){
        return this.proveedorTomaPedido.obtenerTamanio();
    }
    
    @Override
    public boolean comprobacionOpcion (int max,int op){
        if(op>max){
            return false;
        }else{
            return true;
        }
    }
}
