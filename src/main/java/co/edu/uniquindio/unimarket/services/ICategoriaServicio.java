package co.edu.uniquindio.unimarket.services;

import java.util.List;

import co.edu.uniquindio.unimarket.models.Categoria;


public interface ICategoriaServicio {
	
	public List<Categoria> obtenerTodo();
	
	public Categoria guardarCategoria(Categoria categoria);
	
	public Categoria obtenerPorId(long id);
	
	public void eliminarCategoria(long id);	

}
