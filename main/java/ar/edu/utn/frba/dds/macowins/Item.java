package ar.edu.utn.frba.dds.macowins;

class Item {
  Prenda prenda;
  int cantidad;

  public Item(Prenda prenda, int cantidad) {
    this.prenda = prenda;
    this.cantidad = cantidad;
  }

  public double importe() {
    return prenda.precio() * cantidad;
  }

  public double itemConRecargo(FormaDePago formaDePago) {
    return this.importe() + formaDePago.recargo(prenda.precio());
  }
}
