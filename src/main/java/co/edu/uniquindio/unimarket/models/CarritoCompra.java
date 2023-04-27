package co.edu.uniquindio.unimarket.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carritocompra")
public class CarritoCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carrito_compra;
    
    @Column(name = "fecha_compra", nullable = false)
    private Date fechaCompra;
    
    @Enumerated(value = EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoCarritoCompra estado;
    
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    public CarritoCompra() {
		// TODO Auto-generated constructor stub
	}

	public CarritoCompra(int id_carrito_compra, Date fechaCompra, EstadoCarritoCompra estado, Usuario usuario) {
		super();
		this.id_carrito_compra = id_carrito_compra;
		this.fechaCompra = fechaCompra;
		this.estado = estado;
		this.usuario = usuario;
	}

	public int getId_carrito_compra() {
		return id_carrito_compra;
	}

	public void setId_carrito_compra(int id_carrito_compra) {
		this.id_carrito_compra = id_carrito_compra;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public EstadoCarritoCompra getEstado() {
		return estado;
	}

	public void setEstado(EstadoCarritoCompra estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
	
    
}
