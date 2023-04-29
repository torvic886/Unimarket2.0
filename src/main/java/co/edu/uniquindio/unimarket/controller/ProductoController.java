package co.edu.uniquindio.unimarket.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.unimarket.models.Producto;
import co.edu.uniquindio.unimarket.services.ProductoServicioImpl;


@RestController
@RequestMapping("/api/v2")
public class ProductoController {
	
	@Autowired
	ProductoServicioImpl productoservicioimpl;
	
	
	@GetMapping("/Productos")
	public List<Producto> obtenerProductos(){
		return productoservicioimpl.obtenerTodo();	
	}
	
	
	 @PostMapping("/guardar")
	 public ResponseEntity<Producto>guardarProducto(@RequestBody Producto producto) 
	 {
		 Producto nuevo_producto = productoservicioimpl.guardarProducto(producto);
		 return new ResponseEntity<>(nuevo_producto, HttpStatus.CREATED);
		 
	 }
	@GetMapping("/producto/{id}")	 
	 public ResponseEntity<Producto> obtenerProductoId(@PathVariable long id, @RequestBody Producto producto){
		Producto productoPorId = productoservicioimpl.obtenerPorId(id);
		 return ResponseEntity.ok(productoPorId);
		 
	 }
	 
	 @PutMapping("/producto/{id}")
	 public ResponseEntity<Producto>actualizar(@PathVariable long id, @RequestBody Producto producto)
	 {
		 Producto productoPorId = productoservicioimpl.obtenerPorId(id);
		 
		 productoPorId.setNombre(producto.getNombre());
		 productoPorId.setDescripcion(producto.getDescripcion());
		 productoPorId.setPrecio(producto.getPrecio());
		 productoPorId.setDisponibilidad(producto.getDisponibilidad());
		 productoPorId.setFechaLimite(producto.getFechaLimite());
		 productoPorId.setUsuario(producto.getUsuario());
		 productoPorId.setCategoria(producto.getCategoria());
		 productoPorId.setEstadoProducto(producto.getEstadoProducto());	 
		 productoPorId.setComentarios(producto.getComentarios());
		 
		 Producto producto_actualizado = productoservicioimpl.guardarProducto(productoPorId);
		 return new ResponseEntity<>(producto_actualizado, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/producto/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarProducto(@PathVariable long id)
	 {
		 this.productoservicioimpl.eliminarProducto(id);
		 
		 HashMap<String, Boolean> estadoProductoEliminado = new HashMap<>();
		 estadoProductoEliminado.put("eliminado", true);
		 return ResponseEntity.ok(estadoProductoEliminado);
	 }	

}
