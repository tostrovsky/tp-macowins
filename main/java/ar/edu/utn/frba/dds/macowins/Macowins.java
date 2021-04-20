package ar.edu.utn.frba.dds.macowins;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Macowins {

  List<Venta> ventas = new ArrayList<>();

  double gananciasPorFecha(LocalDate unaFecha) {
    List<Venta> ventasEnFecha = this.ventasEnFecha(unaFecha);
    return ventasEnFecha.stream().mapToDouble(Venta::facturado).sum();
  }

  List<Venta> ventasEnFecha(LocalDate unaFecha) {
    return ventas.stream().filter(vnta -> vnta.esDeLaFecha(unaFecha)).collect(Collectors.toList());
  }

  void registrarVenta(Venta unaVenta) {
    ventas.add(unaVenta);
  }
}
