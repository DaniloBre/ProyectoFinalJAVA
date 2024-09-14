package CoderHouse.DaniloBrena.EntregaFinalJV.model;

import jakarta.persistence.*;

@Entity
@Table(name="FERRETERIA")

public class Ferreteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String n_material; /*numero de pertenencia del materiales*/
    private String nombre;
    private double precio;




    /*Gettes y seters*/
    public Long getId() {
        return id;
    }

    public String getN_material() {
        return n_material;
    }

    public void setN_material(String n_material) {
        this.n_material = n_material;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
