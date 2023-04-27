package co.edu.uniquindio.unimarket.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "producto")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;	
	
    @Column(name = "nombre")    
	private String nombre;
	
    @Column(name = "descripcion")     
	private String descripcion;
	
    @Column(name = "precio")       
	private String precio;

    @Column(name = "disponibilidad")      
	private String disponibilidad;
	
    @Column(name="fecha_limite")
    private Date fechaLimite;
	  
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	    
	@ManyToOne
	@JoinColumn(name = "id_estado_producto")
	private EstadoProducto estadoProducto;	
	
//	@ManyToOne
//	@JsonIgnore
//	@JoinColumn(name = "id_comentario")
//	private Comentario comentario;
	
	

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_comentario")
    private List<Comentario> comentarios;	
	
//	public Comentario getComentario() {
//		return comentario;
//	}
//
//
//	public void setComentario(Comentario comentario) {
//		this.comentario = comentario;
//	}
    
    


	public Producto() 
	{

	}
	

	public List<Comentario> getComentarios() {
		return comentarios;
	}


	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}


	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}
	
	
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	
	public EstadoProducto getEstadoProducto() {
		return estadoProducto;
	}


	public void setEstadoProducto(EstadoProducto estadoProducto) {
		this.estadoProducto = estadoProducto;
	}



}
