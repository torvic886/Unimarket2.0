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
@Table(name = "moderador")
public class Moderador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moderador")
    private Long idModerador;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "contrasena")
    private String contrasena;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;
    
    public Moderador() {
		// TODO Auto-generated constructor stub
	}

	public Moderador(Long idModerador, String nombreCompleto, String cedula, String email, String telefono,
			String contrasena, Usuario usuario, Producto producto) {
		super();
		this.idModerador = idModerador;
		this.nombreCompleto = nombreCompleto;
		this.cedula = cedula;
		this.email = email;
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.usuario = usuario;
		this.producto = producto;
	}

	public Long getIdModerador() {
		return idModerador;
	}

	public void setIdModerador(Long idModerador) {
		this.idModerador = idModerador;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    
    
}
