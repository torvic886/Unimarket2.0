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


import co.edu.uniquindio.unimarket.models.DetalleCompra;
import co.edu.uniquindio.unimarket.services.DetalleCompraServicioImpl;

@RestController
@RequestMapping("/api/v10")
public class DetalleCompraController {
	
	@Autowired
	DetalleCompraServicioImpl detalleCompraServicioImpl;
	
	
	@GetMapping("/DetalleCompra")
	public List<DetalleCompra> obtenerDetalleCompra(){
		return detalleCompraServicioImpl.obtenerTodo();	
	}
	
	
	 @PostMapping("/guardar")
	 public ResponseEntity<DetalleCompra>guardarDetalleCompra(@RequestBody DetalleCompra detalleCompra) 
	 {
		 DetalleCompra nuevo_DetalleCompra= detalleCompraServicioImpl.guardarDetalleCompra(detalleCompra);
		 return new ResponseEntity<>(nuevo_DetalleCompra, HttpStatus.CREATED);
		 
	 }
	@GetMapping("/detalleCompra/{id}")	 
	 public ResponseEntity<DetalleCompra> obtenerDetalleCompraId(@PathVariable long id, @RequestBody DetalleCompra detalleCompra){
		DetalleCompra detalledetalleCompraPorId = detalleCompraServicioImpl.obtenerPorId(id);
		 return ResponseEntity.ok(detalledetalleCompraPorId);
		 
	 }
	 
	 @PutMapping("/detalleCompra/{id}")
	 public ResponseEntity<DetalleCompra>actualizar(@PathVariable long id, @RequestBody DetalleCompra detalleCompra)
	 {
		 DetalleCompra detalleCompraPorId = detalleCompraServicioImpl.obtenerPorId(id);
		 
		 detalleCompraPorId.setCantidad(detalleCompra.getCantidad());
		 detalleCompraPorId.setPrecioUnitario(detalleCompra.getPrecioUnitario());
		 detalleCompraPorId.setProducto(detalleCompra.getProducto());


		 
		 DetalleCompra compra_actualizada = detalleCompraServicioImpl.guardarDetalleCompra(detalleCompraPorId);
		 return new ResponseEntity<>(compra_actualizada, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/detalleCompra/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarDetalleCompra(@PathVariable long id)
	 {
		 this.detalleCompraServicioImpl.eliminarDetalleCompra(id);
		 
		 HashMap<String, Boolean> estadoDetalleCompraEliminado = new HashMap<>();
		 estadoDetalleCompraEliminado.put("eliminada", true);
		 return ResponseEntity.ok(estadoDetalleCompraEliminado);
	 }	

}
