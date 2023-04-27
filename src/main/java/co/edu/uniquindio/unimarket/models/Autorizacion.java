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
@Table(name = "autorizacion")
public class Autorizacion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autorizacion")
    private Long idAutorizacion;

    @Enumerated(value = EnumType.STRING)
    private EstadoAutorizacion estado;

    @Column(name = "fecha_autorizacion")
    private Date fechaAutorizacion;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moderador")
    private Moderador moderador;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;
    
    // Constructor vacío
    public Autorizacion() {
    }
    
    
	// Constructor con parámetros
    public Autorizacion(Long idAutorizacion, EstadoAutorizacion estado, Date fechaAutorizacion, Moderador moderador,Producto producto) {
		this.idAutorizacion = idAutorizacion;
		this.estado = estado;
		this.fechaAutorizacion = fechaAutorizacion;
		this.moderador = moderador;
		this.producto = producto;
	}


	public Long getIdAutorizacion() {
		return idAutorizacion;
	}

	public void setIdAutorizacion(Long idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}

	public EstadoAutorizacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoAutorizacion estado) {
		this.estado = estado;
	}

	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public Moderador getModerador() {
		return moderador;
	}

	public void setModerador(Moderador moderador) {
		this.moderador = moderador;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
