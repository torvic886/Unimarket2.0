package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.EstadoProducto;
import co.edu.uniquindio.unimarket.repositories.EstadoProductoRepositorio;
@Service
public class EstadoProductoServicioImpl implements IEstadoProductoServicio{

	@Autowired
	EstadoProductoRepositorio estadoProductoRepositorio;	
	
	@Override
	public List<EstadoProducto> obtenerTodo() {
		return estadoProductoRepositorio.findAll();
	}

	@Override
	public EstadoProducto guardarEstadoProducto(EstadoProducto estadoProducto) {
		return estadoProductoRepositorio.save(estadoProducto);
	}

	@Override
	public EstadoProducto obtenerPorId(long id) {
		return estadoProductoRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarEstadoProducto(long id) {
		estadoProductoRepositorio.deleteById(id);
		
	}

}
