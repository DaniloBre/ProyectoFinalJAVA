package CoderHouse.DaniloBrena.EntregaFinalJV.service;


import CoderHouse.DaniloBrena.EntregaFinalJV.model.Cliente;
import CoderHouse.DaniloBrena.EntregaFinalJV.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente agregaCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarCliente(Long id){
        return clienteRepository.findById(id);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
