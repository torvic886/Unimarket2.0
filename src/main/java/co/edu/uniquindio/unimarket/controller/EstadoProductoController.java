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


import co.edu.uniquindio.unimarket.models.EstadoProducto;
import co.edu.uniquindio.unimarket.services.EstadoProductoServicioImpl;

@RestController
@RequestMapping("/api/v12")
public class EstadoProductoController {
	
	@Autowired
	EstadoProductoServicioImpl estadoProductoServicioImpl;
	
	
	@GetMapping("/EstadosProducto")
	public List<EstadoProducto> obtenerEstadoProducto(){
		return estadoProductoServicioImpl.obtenerTodo();	
	}
	
	
	 @PostMapping("/guardar")
	 public ResponseEntity<EstadoProducto>guardarEstadoProducto(@RequestBody EstadoProducto estadoProducto) 
	 {
		 EstadoProducto nuevo_estadoProducto = estadoProductoServicioImpl.guardarEstadoProducto(estadoProducto);
		 return new ResponseEntity<>(nuevo_estadoProducto, HttpStatus.CREATED);
		 
	 }
	@GetMapping("/estadoProducto/{id}")	 
	 public ResponseEntity<EstadoProducto> obtenerEstadoProductoId(@PathVariable long id, @RequestBody EstadoProducto estadoProducto){
		EstadoProducto estadoProductoPorId = estadoProductoServicioImpl.obtenerPorId(id);
		 return ResponseEntity.ok(estadoProductoPorId);
		 
	 }
	 
	 @PutMapping("/estadoProducto/{id}")
	 public ResponseEntity<EstadoProducto>actualizar(@PathVariable long id, @RequestBody EstadoProducto estadoProducto)
	 {
		 EstadoProducto estadoProductoPorId = estadoProductoServicioImpl.obtenerPorId(id);
		 
		 estadoProductoPorId.setNombre(estadoProducto.getNombre());


		 
		 EstadoProducto estadoProducto_actualizado = estadoProductoServicioImpl.guardarEstadoProducto(estadoProductoPorId);
		 return new ResponseEntity<>(estadoProducto_actualizado, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/estadoProducto/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarEstadoProducto(@PathVariable long id)
	 {
		 this.estadoProductoServicioImpl.eliminarEstadoProducto(id);
		 
		 HashMap<String, Boolean> estadoEstadoProductoEliminada = new HashMap<>();
		 estadoEstadoProductoEliminada.put("eliminada", true);
		 return ResponseEntity.ok(estadoEstadoProductoEliminada);
	 }	

}
