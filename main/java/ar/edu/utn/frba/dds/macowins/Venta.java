package ar.edu.utn.frba.dds.macowins;

import java.time.LocalDate;
import java.util.*;

class Venta {

  LocalDate unaFecha;
  FormaDePago formaDePago;
  List<Item> listaItems;

  public Venta(LocalDate unaFecha, FormaDePago formaDePago, List<Item> listaItems) {
    this.unaFecha = unaFecha;
    this.formaDePago = formaDePago;
    this.listaItems = listaItems;
  }

  double facturado() {
    return listaItems.stream().mapToDouble(unItem -> unItem.itemConRecargo(formaDePago)).sum();

  }

  boolean esDeLaFecha(LocalDate otraFecha) {
    return unaFecha == otraFecha;
  }

  void agregarItem(Item unItem) {
    listaItems.add(unItem);
  }
}


