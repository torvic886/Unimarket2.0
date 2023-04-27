package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.Moderador;
import co.edu.uniquindio.unimarket.repositories.ModeradorRepositorio;

@Service
public class ModeradorServicioImpl implements IModeradorServicio {

	@Autowired
	ModeradorRepositorio moderadorRepositorio;
	
	@Override
	public List<Moderador> obtenerTodo() {
		return moderadorRepositorio.findAll();
	}

	@Override
	public Moderador guardarModerador(Moderador moderador) {
		return moderadorRepositorio.save(moderador);
	}

	@Override
	public Moderador obtenerPorId(long id) {
		return moderadorRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarModerador(long id) {
		moderadorRepositorio.deleteById(id);
		
	}

}
