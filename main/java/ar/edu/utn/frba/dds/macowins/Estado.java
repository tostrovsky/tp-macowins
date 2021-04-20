package ar.edu.utn.frba.dds.macowins;

public interface Estado {
  double precioFinalDePrenda(double precio);
}

class Nueva implements Estado {
  public double precioFinalDePrenda(double precio) {
    return precio;
  }
}

class EnPromocion implements Estado {
  double valorFijo;

  EnPromocion(double valorFijo) {
    this.valorFijo = valorFijo;
  }

  public double precioFinalDePrenda(double precio) {
    return precio - valorFijo;
  }
}

class EnLiquidacion implements Estado {
  public double precioFinalDePrenda(double precio) {
    return precio * 0.5;
  }
}