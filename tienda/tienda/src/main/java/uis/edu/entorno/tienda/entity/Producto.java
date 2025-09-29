package uis.edu.entorno.tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.io.Serializable;

@Entity
@Table(name = "producto")
@Data
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Column(length = 255, nullable = false)
    private String nombre;

    @NotNull(message = "El IVA de compra es obligatorio")
    @Positive(message = "El IVA de compra debe ser un valor positivo")
    @Column(nullable = false)
    private Double ivaCompra;

    @NotNull(message = "El precio de compra es obligatorio")
    @Positive(message = "El precio de compra debe ser un valor positivo")
    @Column(nullable = false)
    private Double precioCompra;

    @NotNull(message = "El precio de venta es obligatorio")
    @Positive(message = "El precio de venta debe ser un valor positivo")
    @Column(nullable = false)
    private Double precioVenta;

    // --- Relación con Proveedor ---
    @NotNull(message = "El producto debe tener un proveedor asociado")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProveedor", nullable = false)
    private Proveedor proveedor;
}