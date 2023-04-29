package co.edu.uniquindio.unimarket.services;

import java.util.List;

import co.edu.uniquindio.unimarket.models.Comentario;


public interface IComentarioServicio {
	
	public List<Comentario> obtenerTodo();
	
	public Comentario guardarComentario(Comentario comentario);
	
	public Comentario obtenerPorId(long id);
	
	public void eliminarComentario(long id);			

}
