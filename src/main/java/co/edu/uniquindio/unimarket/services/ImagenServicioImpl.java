package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.Imagen;
import co.edu.uniquindio.unimarket.repositories.ImagenRepositorio;

@Service
public class ImagenServicioImpl implements IImagenServicio{

	@Autowired
	ImagenRepositorio imagenRepositorio;
	
	@Override
	public List<Imagen> obtenerTodo() {
		return imagenRepositorio.findAll();
	}

	@Override
	public Imagen guardarImagen(Imagen imagen) {
		return imagenRepositorio.save(imagen);
	}

	@Override
	public Imagen obtenerPorId(long id) {
		return imagenRepositorio.findById(id).orElse(null);

	}

	@Override
	public void eliminarImagen(long id) {
		imagenRepositorio.deleteById(id);
		
	}

}
