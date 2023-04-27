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

import co.edu.uniquindio.unimarket.models.Autorizacion;
import co.edu.uniquindio.unimarket.services.AutorizacionServicioImpl;

@RestController
@RequestMapping("/api/v4")
public class AutorizacionController {
	
	@Autowired
	AutorizacionServicioImpl autorizacionServicioImpl;
	
	@GetMapping("/Autorizaciones")
	public List<Autorizacion> obtenerAutorizacions(){
		return autorizacionServicioImpl.obtenerTodo();	
	}
	
	@GetMapping("/autorizacion/{id}")	 
	public ResponseEntity<Autorizacion>guardarAutorizacion(@RequestBody Autorizacion autorizacion)
	{
		Autorizacion nueva_autorizacion = autorizacionServicioImpl.guardarAutorizacion(autorizacion);
		 return new ResponseEntity<>(nueva_autorizacion, HttpStatus.CREATED);

	}
	
	 @PutMapping("/autorizacion/{id}")
	 public ResponseEntity<Autorizacion>actualizar(@PathVariable long id, @RequestBody Autorizacion autorizacion)
	 {
		 Autorizacion actualizacionPorId = autorizacionServicioImpl.obtenerPorId(id);

		 actualizacionPorId.setEstado(autorizacion.getEstado());
		 actualizacionPorId.setFechaAutorizacion(autorizacion.getFechaAutorizacion());
		 actualizacionPorId.setModerador(autorizacion.getModerador());
		 actualizacionPorId.setProducto(autorizacion.getProducto());
		 
		 Autorizacion autorizacion_actualizada = autorizacionServicioImpl.guardarAutorizacion(actualizacionPorId);

		 return new ResponseEntity<>(autorizacion_actualizada, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/autorizacion/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarAutorizacion(@PathVariable long id)
	 {
		 this.autorizacionServicioImpl.eliminarAutorizacion(id);
		 
		 HashMap<String, Boolean> estadoAutorizadoEliminado = new HashMap<>();
		 estadoAutorizadoEliminado.put("eliminado", true);
		 return ResponseEntity.ok(estadoAutorizadoEliminado);
	 }	
	 

}
