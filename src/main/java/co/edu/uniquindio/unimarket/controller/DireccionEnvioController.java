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


import co.edu.uniquindio.unimarket.models.DireccionEnvio;
import co.edu.uniquindio.unimarket.services.DireccionEnvioServicioImpl;

@RestController
@RequestMapping("/api/v11")
public class DireccionEnvioController {
	
	@Autowired
	DireccionEnvioServicioImpl  direccionEnvioServicioImpl;
	
	
	@GetMapping("/Direcciones")
	public List<DireccionEnvio> obtenerDirecciones(){
		return direccionEnvioServicioImpl.obtenerTodo();	
	}
	
	
	 @PostMapping("/guardar")
	 public ResponseEntity<DireccionEnvio>guardarDireccionEnvio(@RequestBody DireccionEnvio direccionEnvio) 
	 {
		 DireccionEnvio nueva_direccionEnvio = direccionEnvioServicioImpl.guardarDireccionEnvio(direccionEnvio);
		 return new ResponseEntity<>(nueva_direccionEnvio, HttpStatus.CREATED);
		 
	 }
	@GetMapping("/direccionEnvio/{id}")	 
	 public ResponseEntity<DireccionEnvio> obtenerDireccionEnvioId(@PathVariable long id, @RequestBody DireccionEnvio direccionEnvio){
		DireccionEnvio direccionEnvioPorId = direccionEnvioServicioImpl.obtenerPorId(id);
		 return ResponseEntity.ok(direccionEnvioPorId);
		 
	 }
	 
	 @PutMapping("/direccionEnvio/{id}")
	 public ResponseEntity<DireccionEnvio>actualizar(@PathVariable long id, @RequestBody DireccionEnvio direccionEnvio)
	 {
		 DireccionEnvio direccionEnvioPorId = direccionEnvioServicioImpl.obtenerPorId(id);
		 
		 direccionEnvioPorId.setDireccion(direccionEnvio.getDireccion());


		 
		 DireccionEnvio direccionEnvio_actualizada = direccionEnvioServicioImpl.guardarDireccionEnvio(direccionEnvioPorId);
		 return new ResponseEntity<>(direccionEnvio_actualizada, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/direccionEnvio/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarDireccionEnvio(@PathVariable long id)
	 {
		 this.direccionEnvioServicioImpl.eliminarDireccionEnvio(id);
		 
		 HashMap<String, Boolean> estadoDireccionEnvioEliminada = new HashMap<>();
		 estadoDireccionEnvioEliminada.put("eliminada", true);
		 return ResponseEntity.ok(estadoDireccionEnvioEliminada);
	 }	

}
