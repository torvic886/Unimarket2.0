package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.DireccionEnvio;
import co.edu.uniquindio.unimarket.repositories.DireccionEnvioRepositorio;

@Service
public class DireccionEnvioServicioImpl implements IDireccionEnvioServicio{

	@Autowired
	DireccionEnvioRepositorio direccionEnvioRepositorio;
	
	@Override
	public List<DireccionEnvio> obtenerTodo() {
		return direccionEnvioRepositorio.findAll();
	}

	@Override
	public DireccionEnvio guardarDireccionEnvio(DireccionEnvio direccionEnvio) {
		return direccionEnvioRepositorio.save(direccionEnvio);
	}

	@Override
	public DireccionEnvio obtenerPorId(long id) {
		return direccionEnvioRepositorio.findById(id).orElse(null);

	}

	@Override
	public void eliminarDireccionEnvio(long id) {
		direccionEnvioRepositorio.deleteById(id);
		
	}

}
