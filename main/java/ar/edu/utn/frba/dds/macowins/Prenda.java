package ar.edu.utn.frba.dds.macowins;

class Prenda {

  double precioBase;
  Tipo tipo;
  Estado estadoDePrenda;

  public Prenda(double precioInicial, Tipo tipo, Estado estadoDePrenda) {
    this.precioBase = precioInicial;
    this.tipo = tipo;
    this.estadoDePrenda = estadoDePrenda;
  }

  double precio() {
    return estadoDePrenda.precioFinalDePrenda(precioBase);
  }

  public Tipo getTipo() {
    return tipo;
  }
}


