/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomarpedido;

import menuprincipal.*;

/**
 *
 * @author utku36
 */
public interface ContratoVistaPedido {
    public void mostrarVariedadesDisponibles();
    public void mostrarTiposCoccionDisponibles();
    public void mostrarSeleccionVariedadPizza();
    public void mostrarOPcionErronea();
    public void mostrarSeleccionarTamanioPizza();
   
    public void PedirCantidad ();
    public void irMenuPrincipal();

    public void mostrarSeleccionCoccion();
    public void mostrarTamaniosDisponibles();

    public void confirmacion();
}