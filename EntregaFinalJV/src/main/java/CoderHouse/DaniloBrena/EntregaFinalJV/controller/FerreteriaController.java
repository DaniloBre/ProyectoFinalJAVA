package CoderHouse.DaniloBrena.EntregaFinalJV.controller;


import CoderHouse.DaniloBrena.EntregaFinalJV.model.Ferreteria;
import CoderHouse.DaniloBrena.EntregaFinalJV.service.FerreteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/*ejemplo para el local HOSTT

http://localhost:8080/producto

{
  "n_material": "000001",
  "nombre": "Martillo",
  "precio": "10000"

}*/


@RestController
@RequestMapping("/producto")
public class FerreteriaController {
    @Autowired
    private FerreteriaService ferreteriaService;

    @PostMapping("/agregar")
    public Ferreteria agregarProducto(@RequestBody Ferreteria ferreteriaProducto){
        return ferreteriaService.agregarProducto(ferreteriaProducto);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Ferreteria>buscarProducto(@PathVariable Long id){
        return ferreteriaService.buscarProducto(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarrProducto(@PathVariable Long id) {
        ferreteriaService.eliminarrProducto(id);
    }
}
