/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomarpedido.proveedores;
import modelos.*;
import java.util.List;
/**
 *
 * @author andresteve07
 */
public interface ProveedorTomaPedido {
    List<VariedadPizza> obtenerVariedades();
    List<TipoPizza> obtenerTipos();
    List<TamanioPizza> obtenerTamanio();
    List<Pizza> obtenerPizzas();
    public void guardarPedido(Pedido pedido);
}
