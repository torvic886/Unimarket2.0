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

import co.edu.uniquindio.unimarket.models.Compra;
import co.edu.uniquindio.unimarket.services.CompraServicioImpl;


@RestController
@RequestMapping("/api/v7")
public class CompraController {

	@Autowired
	CompraServicioImpl compraservicioimpl;
	
	
	@GetMapping("/Compras")
	public List<Compra> obtenerCompras(){
		return compraservicioimpl.obtenerTodo();	
	}
	
	
	 @PostMapping("/guardar")
	 public ResponseEntity<Compra>guardarCompra(@RequestBody Compra compra) 
	 {
		 Compra nueva_compra = compraservicioimpl.guardarCompra(compra);
		 return new ResponseEntity<>(nueva_compra, HttpStatus.CREATED);
		 
	 }
	@GetMapping("/compra/{id}")	 
	 public ResponseEntity<Compra> obtenerCompraId(@PathVariable long id, @RequestBody Compra compra){
		Compra compraPorId = compraservicioimpl.obtenerPorId(id);
		 return ResponseEntity.ok(compraPorId);
		 
	 }
	 
	 @PutMapping("/compra/{id}")
	 public ResponseEntity<Compra>actualizar(@PathVariable long id, @RequestBody Compra compra)
	 {
		 Compra compraPorId = compraservicioimpl.obtenerPorId(id);
		 
		 compraPorId.setFechaCompra(compra.getFechaCompra());
		 compraPorId.setTotal(compra.getTotal());
		 compraPorId.setEstado(compra.getEstado());
		 compraPorId.setMetodoPago(compra.getMetodoPago());
		 compraPorId.setUsuario(compra.getUsuario());
		 compraPorId.setCarritoCompra(compra.getCarritoCompra());

		 
		 Compra compra_actualizada = compraservicioimpl.guardarCompra(compraPorId);
		 return new ResponseEntity<>(compra_actualizada, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/compra/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarCompra(@PathVariable long id)
	 {
		 this.compraservicioimpl.eliminarCompra(id);
		 
		 HashMap<String, Boolean> estadoCompraEliminada = new HashMap<>();
		 estadoCompraEliminada.put("eliminada", true);
		 return ResponseEntity.ok(estadoCompraEliminada);
	 }	
} 
