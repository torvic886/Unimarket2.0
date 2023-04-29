package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.Categoria;
import co.edu.uniquindio.unimarket.repositories.CategoriaRepositorio;

@Service
public class CategoriaServicioImpl implements ICategoriaServicio {

	
	@Autowired
	CategoriaRepositorio categoriaRepositorio;	
	
	@Override
	public List<Categoria> obtenerTodo() {
		return categoriaRepositorio.findAll();
	}

	@Override
	public Categoria guardarCategoria(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}

	@Override
	public Categoria obtenerPorId(long id) {
		return categoriaRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarCategoria(long id) {
		categoriaRepositorio.deleteById(id);
		
	}

}
