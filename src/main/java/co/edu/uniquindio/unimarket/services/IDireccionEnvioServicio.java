package co.edu.uniquindio.unimarket.services;

import java.util.List;

import co.edu.uniquindio.unimarket.models.DireccionEnvio;

public interface IDireccionEnvioServicio {
	
	public List<DireccionEnvio> obtenerTodo();
	
	public DireccionEnvio guardarDireccionEnvio(DireccionEnvio direccionEnvio);
	
	public DireccionEnvio obtenerPorId(long id);
	
	public void eliminarDireccionEnvio(long id);		

}
