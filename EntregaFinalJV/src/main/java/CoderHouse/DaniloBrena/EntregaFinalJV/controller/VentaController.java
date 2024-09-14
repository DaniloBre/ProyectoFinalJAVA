package CoderHouse.DaniloBrena.EntregaFinalJV.controller;


import CoderHouse.DaniloBrena.EntregaFinalJV.model.Venta;
import CoderHouse.DaniloBrena.EntregaFinalJV.model.VentaProducto;
import CoderHouse.DaniloBrena.EntregaFinalJV.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/*ejemplo para el local HOSTT

 http://localhost:8080/venta

{
    "ferreteria": {
        "id": 1
    },
    "cantidadVendida": 2
}
* */


@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;
    @PostMapping("/crear/{id_cliente}")
    private Venta RealizarVenta(
            @PathVariable Long id_cliente,
            @RequestBody VentaProducto ventaProducto){
        return ventaService.realizarVenta(id_cliente, ventaProducto.getFerreteria().getId(), ventaProducto.getCantidadVendida());
    }

    @PostMapping("/ventas")
    public Venta ventasRealzadas(@RequestBody Venta venta){
        return ventaService.vetaRealizada(venta);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Venta>buscarventa(@PathVariable Long id){
        return ventaService.buscarventa(id);
    }
}
