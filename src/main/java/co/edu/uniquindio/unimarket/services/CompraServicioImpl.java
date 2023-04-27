package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.Compra;
import co.edu.uniquindio.unimarket.repositories.CompraRepositorio;

@Service
public class CompraServicioImpl implements ICompraServicio {

	@Autowired
	CompraRepositorio compraRepositorio;
	
	@Override
	public List<Compra> obtenerTodo() {
		return compraRepositorio.findAll();
	}

	@Override
	public Compra guardarCompra(Compra compra) {
		return compraRepositorio.save(compra);
	}

	@Override
	public Compra obtenerPorId(long id) {
		return compraRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarCompra(long id) {
		compraRepositorio.deleteById(id);
		
	}

}
