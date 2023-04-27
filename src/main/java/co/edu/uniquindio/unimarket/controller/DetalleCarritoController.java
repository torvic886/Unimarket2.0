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

import co.edu.uniquindio.unimarket.models.DetalleCarrito;
import co.edu.uniquindio.unimarket.services.DetalleCarritoServicioImpl;

@RestController
@RequestMapping("/api/v9")
public class DetalleCarritoController {
	
	@Autowired
	DetalleCarritoServicioImpl detalleCarritoServicioImpl;

	@GetMapping("/DetalleCarrito")
	public List<DetalleCarrito> obtenerDetalleCarrito(){
		return detalleCarritoServicioImpl.obtenerTodo();	
	}
	
	
	 @PostMapping("/guardar")
	 public ResponseEntity<DetalleCarrito>guardarDetalleCarrito(@RequestBody DetalleCarrito detalleCarrito) 
	 {
		 DetalleCarrito nueva_detalleCarrito= detalleCarritoServicioImpl.guardarDetalleCarrito(detalleCarrito);
		 return new ResponseEntity<>(nueva_detalleCarrito, HttpStatus.CREATED);
		 
	 }
	@GetMapping("/detalleCarrito/{id}")	 
	 public ResponseEntity<DetalleCarrito> obtenerDetalleCarritoId(@PathVariable long id, @RequestBody DetalleCarrito detalleCarrito){
		DetalleCarrito detalleCarritoPorId = detalleCarritoServicioImpl.obtenerPorId(id);
		 return ResponseEntity.ok(detalleCarritoPorId);
		 
	 }
	 
	 @PutMapping("/detalleCarrito/{id}")
	 public ResponseEntity<DetalleCarrito>actualizar(@PathVariable long id, @RequestBody DetalleCarrito detalleCarrito)
	 {
		 DetalleCarrito detalleCarritoPorId = detalleCarritoServicioImpl.obtenerPorId(id);
		 
		 detalleCarritoPorId.setCantidad(detalleCarrito.getCantidad());
		 detalleCarritoPorId.setSubtotal(detalleCarrito.getSubtotal());
		 detalleCarritoPorId.setCarritoCompra(detalleCarrito.getCarritoCompra());
		 detalleCarritoPorId.setProducto(detalleCarrito.getProducto());


		 
		 DetalleCarrito detalleCarrito_actualizado = detalleCarritoServicioImpl.guardarDetalleCarrito(detalleCarritoPorId);
		 return new ResponseEntity<>(detalleCarrito_actualizado, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/detalleCarrito/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarDetalleCarrito(@PathVariable long id)
	 {
		 this.detalleCarritoServicioImpl.eliminarDetalleCarrito(id);
		 
		 HashMap<String, Boolean> estadoDetalleCarritoEliminado = new HashMap<>();
		 estadoDetalleCarritoEliminado.put("eliminada", true);
		 return ResponseEntity.ok(estadoDetalleCarritoEliminado);
	 }		
	
	
}
