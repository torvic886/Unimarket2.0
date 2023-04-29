package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.Comentario;
import co.edu.uniquindio.unimarket.repositories.ComentarioRepositorio;

@Service
public class ComentarioServicioImpl implements IComentarioServicio{

	
	@Autowired
	ComentarioRepositorio comentariorepositorio;
	
	@Override
	public List<Comentario> obtenerTodo() {
		return comentariorepositorio.findAll();
	}

	@Override
	public Comentario guardarComentario(Comentario comentario) {
		return comentariorepositorio.save(comentario);
	}

	@Override
	public Comentario obtenerPorId(long id) {
		return comentariorepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarComentario(long id) {
		comentariorepositorio.deleteById(id);
		
	}

}
