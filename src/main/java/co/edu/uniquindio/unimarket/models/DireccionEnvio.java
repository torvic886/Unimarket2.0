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
@Table(name = "direccionenvio")
public class DireccionEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion_envio")
    private Integer idDireccionEnvio;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "region")
    private String region;

    @Column(name = "codigoPostal", nullable = false)
    private String codigoPostal;

    @Column(name = "pais", nullable = false)
    private String pais;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    public DireccionEnvio() {
		// TODO Auto-generated constructor stub
	}

	public DireccionEnvio(Integer idDireccionEnvio, String direccion, String ciudad, String region, String codigoPostal,
			String pais, Usuario usuario) {
		super();
		this.idDireccionEnvio = idDireccionEnvio;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.region = region;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
		this.usuario = usuario;
	}

	public Integer getIdDireccionEnvio() {
		return idDireccionEnvio;
	}

	public void setIdDireccionEnvio(Integer idDireccionEnvio) {
		this.idDireccionEnvio = idDireccionEnvio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
    

}
