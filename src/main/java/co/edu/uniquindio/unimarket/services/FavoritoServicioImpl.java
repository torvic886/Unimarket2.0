package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.Favorito;
import co.edu.uniquindio.unimarket.repositories.FavoritoRepositorio;

@Service
public class FavoritoServicioImpl implements IFavoritoServicio{

	@Autowired
	FavoritoRepositorio favoritoRepositorio;
	
	@Override
	public List<Favorito> obtenerTodo() {
		return favoritoRepositorio.findAll();
	}

	@Override
	public Favorito guardarFavorito(Favorito favorito) {
		return favoritoRepositorio.save(favorito);
	}

	@Override
	public Favorito obtenerPorId(long id) {
		return favoritoRepositorio.findById(id).orElse(null);

	}

	@Override
	public void eliminarFavorito(long id) {
		favoritoRepositorio.deleteById(id);
		
	}

}
