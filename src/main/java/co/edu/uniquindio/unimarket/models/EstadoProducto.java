package co.edu.uniquindio.unimarket.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadoproducto")
public class EstadoProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_producto")
    private int idEstadoProducto;	
	
    @Column(name = "nombre")
	private String nombre;
	
	public EstadoProducto()
	{
		
	}

	public int getIdEstadoProducto() {
		return idEstadoProducto;
	}

	public void setIdEstadoProducto(int idEstadoProducto) {
		this.idEstadoProducto = idEstadoProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
