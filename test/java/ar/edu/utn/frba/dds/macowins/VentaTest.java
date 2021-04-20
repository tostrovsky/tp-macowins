package ar.edu.utn.frba.dds.macowins;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static ar.edu.utn.frba.dds.macowins.Tipo.*;
import static org.junit.jupiter.api.Assertions.*;

public class VentaTest {

    LocalDate unaFecha = LocalDate.of(2021, 2, 21);
    Prenda camisaFacheraNueva = new Prenda( 1300.00,CAMISA, new Nueva());
    Prenda jeansHorriblesLiquidacion = new Prenda(900.00,PANTALON, new EnLiquidacion());
    Macowins macowins = new Macowins();

    @Test
    public void elPrecioDeUnaVentaEnEfectivoEsDeCantidadXPrecio() {
        assertEquals(camisaFacheraNueva.precio()*4, ventaDeNPrendasIgualesEnEfectivo(camisaFacheraNueva, unaFecha, 4).facturado());
        assertEquals(jeansHorriblesLiquidacion.precio()*7, ventaDeNPrendasIgualesEnEfectivo(jeansHorriblesLiquidacion, unaFecha, 7).facturado());

    }

    @Test
    public void elPrecioDeUnaVentaDelPantalonYCamisaConTarjetaConCoeficiente32Y6CuotasEsDe2151coma5() {
        assertEquals(2151.5, ventaDe2PrendasConTarjeta(camisaFacheraNueva, jeansHorriblesLiquidacion, unaFecha).facturado());
    }

    @Test
    public void gananciasDelDiaSiSeHizo2VentasDe1959Coma5Y1300EsDe3451Coma5() {
        macowins.registrarVenta(ventaDeNPrendasIgualesEnEfectivo(camisaFacheraNueva, unaFecha, 1));
        macowins.registrarVenta(ventaDe2PrendasConTarjeta(camisaFacheraNueva, jeansHorriblesLiquidacion, unaFecha));
        assertEquals(3451.5, macowins.gananciasPorFecha(unaFecha));
    }


    private Venta ventaDeNPrendasIgualesEnEfectivo(Prenda unaPrenda, LocalDate unaFecha, int cantidad) {
        Item prendaVendida = new Item(unaPrenda, cantidad);
        Venta ventaHecha = new Venta(unaFecha, new Efectivo(), new ArrayList<>() );
        ventaHecha.agregarItem(prendaVendida);
        return ventaHecha;
    }

    private Venta ventaDe2PrendasConTarjeta(Prenda unaPrenda, Prenda otraPrenda, LocalDate unaFecha) {
        Item unItem = new Item(unaPrenda, 1);
        Item otroItem = new Item(otraPrenda, 1);
        Venta ventaHecha = new Venta(unaFecha, new Tarjeta(6, 32),  new ArrayList<>());
        ventaHecha.agregarItem(unItem);
        ventaHecha.agregarItem(otroItem);
        return ventaHecha;
    }

}

/*

public class VentaTest {







    @Test
    public void gananciasDelDiaSiSeHizo2VentasDe1959Coma5Y1300EsDe3259Coma5() {
        macowins.agregarVenta(ventaDeNPrendasIgualesEnEfectivo(camisaFacheraNueva, unaFecha, 1));
        macowins.agregarVenta(ventaDe2PrendasConTarjeta(camisaFacheraNueva, jeansHorriblesLiquidacion, unaFecha));
        assertEquals(3259.5, macowins.gananciasDelDia(unaFecha));
    }

    private Venta ventaDeNPrendasIgualesEnEfectivo(Prenda unaPrenda, LocalDate unaFecha, Integer cantidad) {
        PrendaYCantidad prendaVendida = new PrendaYCantidad(unaPrenda, cantidad);
        Venta ventaHecha = new Venta(unaFecha, new Efectivo());
        ventaHecha.agregarItem(prendaVendida);
        return ventaHecha;
    }

    private Venta ventaDe2PrendasConTarjeta(Prenda unaPrenda, Prenda otraPrenda, LocalDate unaFecha) {
        PrendaYCantidad unItem = new PrendaYCantidad(unaPrenda, 1);
        PrendaYCantidad otroItem = new PrendaYCantidad(otraPrenda, 1);
        Venta ventaHecha = new Venta(unaFecha, new Tarjeta(32.0, 6));
        ventaHecha.agregarItem(unItem);
        ventaHecha.agregarItem(otroItem);
        return ventaHecha;
    }
}*/