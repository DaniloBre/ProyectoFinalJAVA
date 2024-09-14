package CoderHouse.DaniloBrena.EntregaFinalJV.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaVenta;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnore
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<VentaProducto> ventaProductoList;

    public Venta(){

    }


    /*Gettes y seters*/
    public Long getId() {
        return id;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<VentaProducto> getVentaProducto() {
        return ventaProductoList;
    }

    public void setVentaProductoList(List<VentaProducto> ventaProductoList) {
        this.ventaProductoList = ventaProductoList;
    }
}
