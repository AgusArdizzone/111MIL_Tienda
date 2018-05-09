/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomarpedido;

import java.util.List;
import modelos.TamanioPizza;
import modelos.TipoPizza;
import modelos.VariedadPizza;


/**
 *
 * @author utku36
 */
public interface ContratoPresentadorPedido {
    public int getCantidad();
    public int getCodigoCoccion();
    public int getCodigoTamanio();
    public int getCodigoTipoPizza();
    public void procesarTipoPizzaIngresado(int op);
    public void procesarCoccionSeleccionada(int op);
    public void procesarTamanioSeleccionado(int op);
    public void iniciar();
    public void procesarCantidades(int op);
    public List<VariedadPizza> obtenerVariedades();
    public List<TipoPizza> obtenerTiposCoccion();
    public List<TamanioPizza> obtenerTamanioPizza();
    public void procesarConfirmacion(int op);
    public boolean comprobacionOpcion (int max,int op);
}
