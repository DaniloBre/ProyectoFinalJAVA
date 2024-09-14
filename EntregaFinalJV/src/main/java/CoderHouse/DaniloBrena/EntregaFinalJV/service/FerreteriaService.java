package CoderHouse.DaniloBrena.EntregaFinalJV.service;

import CoderHouse.DaniloBrena.EntregaFinalJV.model.Ferreteria;
import CoderHouse.DaniloBrena.EntregaFinalJV.repository.FerreteriaRepocitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FerreteriaService {

    @Autowired
    private FerreteriaRepocitory ferreteriaRepocitory;

    public Ferreteria agregarProducto(Ferreteria ferreteriaProducto) {
        return ferreteriaRepocitory.save(ferreteriaProducto);
    }

    public Optional<Ferreteria> buscarProducto(Long id) {
        return ferreteriaRepocitory.findById(id);
    }


    public void eliminarrProducto(Long id) {
        ferreteriaRepocitory.deleteById(id);
    }
}
