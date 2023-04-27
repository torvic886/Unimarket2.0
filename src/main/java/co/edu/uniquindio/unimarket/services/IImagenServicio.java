package co.edu.uniquindio.unimarket.services;

import java.util.List;


import co.edu.uniquindio.unimarket.models.Imagen;

public interface IImagenServicio {

	
	public List<Imagen> obtenerTodo();
	
	public Imagen guardarImagen(Imagen imagen);
	
	public Imagen obtenerPorId(long id);
	
	public void eliminarImagen(long id);			

}
