package uis.edu.entorno.tienda.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Entity
@Table(name = "proveedor")
@Data
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String ciudad;

    @Column(length = 255)
    private String direccion;

    @Column(length = 255)
    private String nombre;

    @Column(length = 15)
    private String telefono;

    @Column(length = 100)
    private String nit;
}