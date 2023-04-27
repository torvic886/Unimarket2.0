package co.edu.uniquindio.unimarket.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id_comentario")
	private Long idComentario; 

	@Column(name = "comentario")
	private String comentario;
	
	@Column(name = "fecha_creacion")	
	private Date fechaCreacion;
	
//	@ManyToOne
//	@JoinColumn(name = "id_usuario")
//	private Usuario usuario;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_producto")
//	private Producto producto;
	
	
//	@ManyToOne
//	@JoinColumn(name = "id_categoria")
//	private Categoria categoria;	
	
//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}

	public Comentario() {
		
	}

	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

//	public Producto getProducto() {
//		return producto;
//	}
//
//	public void setProducto(Producto producto) {
//		this.producto = producto;
//	}
	
	 

}
