package co.edu.uniquindio.unimarket.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detallecompra")
public class DetalleCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_compra")
    private int idDetalleCompra;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    
//    @ManyToOne
//    @JoinColumn(name = "id_compra")
//    private Compra compra;
    

    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    
    public DetalleCompra() {
		// TODO Auto-generated constructor stub
	}

	public DetalleCompra(int idDetalleCompra, int cantidad, Double precioUnitario, Compra compra, Producto producto) {
		super();
		this.idDetalleCompra = idDetalleCompra;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.producto = producto;
	}

	public int getIdDetalleCompra() {
		return idDetalleCompra;
	}

	public void setIdDetalleCompra(int idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

//	public Compra getCompra() {
//		return compra;
//	}
//
//	public void setCompra(Compra compra) {
//		this.compra = compra;
//	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    
    
}
