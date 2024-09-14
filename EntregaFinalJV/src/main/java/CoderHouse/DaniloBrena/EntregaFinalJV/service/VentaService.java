package CoderHouse.DaniloBrena.EntregaFinalJV.service;

import CoderHouse.DaniloBrena.EntregaFinalJV.model.*;

import CoderHouse.DaniloBrena.EntregaFinalJV.repository.ClienteRepository;
import CoderHouse.DaniloBrena.EntregaFinalJV.repository.FerreteriaRepocitory;
import CoderHouse.DaniloBrena.EntregaFinalJV.repository.VentaProductoRepocitory;
import CoderHouse.DaniloBrena.EntregaFinalJV.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private FerreteriaRepocitory ferreteriaRepocitory;
    @Autowired
    private VentaProductoRepocitory ventaProductoRepocitory;



    public Venta vetaRealizada(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> buscarventa(Long id) {
        return ventaRepository.findById(id);
    }

    public Venta realizarVenta(Long idCliente, Long id, Integer cantidadVendida) {

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(()-> new RuntimeException("Cliente no encontrado"));

        Ferreteria ferreteria = ferreteriaRepocitory.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontra producto"));


        Venta venta = new Venta();
        venta.setFechaVenta(LocalDate.now());
        venta.setCliente(cliente);
        venta = ventaRepository.save(venta);

        VentaProducto ventaProducto = new VentaProducto();
        ventaProducto.setVenta(venta);
        ventaProducto.setFerreteria(ferreteria);
        ventaProducto.setCantidadVendida(cantidadVendida);
        ventaProductoRepocitory.save(ventaProducto);

        List<VentaProducto> ventaProductoList = new ArrayList<>();
        ventaProductoList.add(ventaProducto);
        venta.setVentaProductoList(ventaProductoList);

        return ventaRepository.save(venta);
    }
}
