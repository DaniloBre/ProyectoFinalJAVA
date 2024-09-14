package CoderHouse.DaniloBrena.EntregaFinalJV.controller;


import CoderHouse.DaniloBrena.EntregaFinalJV.model.Cliente;
import CoderHouse.DaniloBrena.EntregaFinalJV.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/*ejemplo para el local HOSTT

http://localhost:8080/cliente

{
  "nombre": "Danilo",
  "apellido": "Brena",
  "direccion": "Villa Urquiza",
  "email": "email.falso.1@gmail.com",
  "n_telefono": "012-3456-7890",
  "dni": "4548451548",
  "venta": null
}*/


@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/agregar")
    public Cliente agregaCliente(@RequestBody Cliente cliente){
        return clienteService.agregaCliente(cliente);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Cliente> buscarCliente(@PathVariable Long id){
        return clienteService.buscarCliente(id);

    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarrCliente(@PathVariable Long id){
        clienteService.eliminarCliente(id);
    }


}
