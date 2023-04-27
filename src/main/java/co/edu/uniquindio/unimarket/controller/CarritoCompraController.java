package co.edu.uniquindio.unimarket.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.unimarket.models.CarritoCompra;
import co.edu.uniquindio.unimarket.services.CarritoCompraServicioImpl;


@RestController
@RequestMapping("/api/v8")
public class CarritoCompraController {
	
	@Autowired
	CarritoCompraServicioImpl carritoCompraServicioImpl;
	
	@GetMapping("/CarritoCompra")
	public List<CarritoCompra> obtenerCarritoCompra(){
		return carritoCompraServicioImpl.obtenerTodo();	
	}
	
	@GetMapping("/carritoCompra/{id}")	 
	public ResponseEntity<CarritoCompra>guardarCarritoCompra(@RequestBody CarritoCompra carritoCompra)
	{
		CarritoCompra nuevo_carritoCompra = carritoCompraServicioImpl.guardarCarritoCompra(carritoCompra);
		 return new ResponseEntity<>(nuevo_carritoCompra, HttpStatus.CREATED);

	}
	
	 @PutMapping("/carritoCompra/{id}")
	 public ResponseEntity<CarritoCompra>actualizar(@PathVariable long id, @RequestBody CarritoCompra carritoCompra)
	 {
		 CarritoCompra carritoCompraPorId = carritoCompraServicioImpl.obtenerPorId(id);

		 carritoCompraPorId.setFechaCompra(carritoCompra.getFechaCompra());
		 carritoCompraPorId.setEstado(carritoCompra.getEstado());
		 carritoCompraPorId.setUsuario(carritoCompra.getUsuario());
		 
		 CarritoCompra carritoCompra_actualizado = carritoCompraServicioImpl.guardarCarritoCompra(carritoCompraPorId);

		 return new ResponseEntity<>(carritoCompra_actualizado, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/carritoCompra/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarCarritoCompra(@PathVariable long id)
	 {
		 this.carritoCompraServicioImpl.eliminarCarritoCompra(id);
		 
		 HashMap<String, Boolean> estadoCarritoCompraEliminado = new HashMap<>();
		 estadoCarritoCompraEliminado.put("eliminado", true);
		 return ResponseEntity.ok(estadoCarritoCompraEliminado);
	 }	

}
