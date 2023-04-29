package co.edu.uniquindio.unimarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniquindio.unimarket.models.Producto;
import co.edu.uniquindio.unimarket.repositories.ProductoRepositorio;
@Service
public class ProductoServicioImpl implements IProductoServicio {

	@Autowired
	ProductoRepositorio productorepositorio;
	
	@Override
	public List<Producto> obtenerTodo() {
		return productorepositorio.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		return productorepositorio.save(producto);
	}

	@Override
	public Producto obtenerPorId(long id) {
		return productorepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarProducto(long id) {
		productorepositorio.deleteById(id);
		
	}

}
