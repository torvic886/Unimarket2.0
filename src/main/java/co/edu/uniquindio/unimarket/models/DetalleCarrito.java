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
@Table(name = "detallecarrito")
public class DetalleCarrito 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_carrito")
    private int idDetalleCarrito;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "subtotal")
    private Double subtotal;
    
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrito_compra")
    private CarritoCompra carritoCompra;
    
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

	public DetalleCarrito(int idDetalleCarrito, int cantidad, Double subtotal, CarritoCompra carritoCompra,
			Producto producto) {
		super();
		this.idDetalleCarrito = idDetalleCarrito;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.carritoCompra = carritoCompra;
		this.producto = producto;
	}
    
	public DetalleCarrito() {
	}

	public int getIdDetalleCarrito() {
		return idDetalleCarrito;
	}

	public void setIdDetalleCarrito(int idDetalleCarrito) {
		this.idDetalleCarrito = idDetalleCarrito;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public CarritoCompra getCarritoCompra() {
		return carritoCompra;
	}

	public void setCarritoCompra(CarritoCompra carritoCompra) {
		this.carritoCompra = carritoCompra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    
	
}
