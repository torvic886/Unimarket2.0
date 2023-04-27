package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.Autorizacion;
import co.edu.uniquindio.unimarket.repositories.AutorizacionRepositorio;


@Service
public class AutorizacionServicioImpl implements IAutorizacionServicio{

	
	@Autowired
	AutorizacionRepositorio autorizacionRepositorio;
	
	@Override
	public List<Autorizacion> obtenerTodo() {
		return autorizacionRepositorio.findAll();
	}

	@Override
	public Autorizacion guardarAutorizacion(Autorizacion autorizacion) {
		return autorizacionRepositorio.save(autorizacion);
	}

	@Override
	public Autorizacion obtenerPorId(long id) {
		return autorizacionRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarAutorizacion(long id) {
		autorizacionRepositorio.deleteById(id);
		
	}

}
