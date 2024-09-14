package CoderHouse.DaniloBrena.EntregaFinalJV.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class VentaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    @JsonIgnore
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Ferreteria ferreteria;

    private Integer cantidadVendida;


    /*Gettes y seters*/
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Ferreteria getFerreteria() {
        return ferreteria;
    }

    public void setFerreteria(Ferreteria ferreteria) {
        this.ferreteria = ferreteria;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
}
