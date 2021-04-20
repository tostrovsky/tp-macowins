package ar.edu.utn.frba.dds.macowins;

//implementado como interfaz porque es responsabilidad de la forma
//de pago calcular el recargo; NO calcular el importe total.

interface FormaDePago {
  double recargo(double valorPrenda);
}

class Efectivo implements FormaDePago {
  public double recargo(double valorPrenda) {
    return 0;
  }
}

class Tarjeta implements FormaDePago {
  int cantidadCuotas;
  double coeficiente;

  public Tarjeta(int cantidadCuotas, double coeficiente) {
    this.cantidadCuotas = cantidadCuotas;
    this.coeficiente = coeficiente;
  }

  public double recargo(double valorPrenda) {
    return cantidadCuotas * coeficiente + 0.01 * valorPrenda;
  }
}

