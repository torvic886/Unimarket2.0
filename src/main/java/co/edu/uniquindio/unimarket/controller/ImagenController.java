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


import co.edu.uniquindio.unimarket.models.Imagen;
import co.edu.uniquindio.unimarket.services.ImagenServicioImpl;

@RestController
@RequestMapping("/api/v14")
public class ImagenController {
	
	
	@Autowired
	ImagenServicioImpl imagenServicioImpl;
	
	
	@GetMapping("/Imagenes")
	public List<Imagen> obtenerImagenes(){
		return imagenServicioImpl.obtenerTodo();	
	}
	
	
	 @PostMapping("/guardar")
	 public ResponseEntity<Imagen>guardarImagen(@RequestBody Imagen imagen) 
	 {
		 Imagen nueva_imagen = imagenServicioImpl.guardarImagen(imagen);
		 return new ResponseEntity<>(nueva_imagen, HttpStatus.CREATED);
		 
	 }
	@GetMapping("/imagen/{id}")	 
	 public ResponseEntity<Imagen> obtenerImagenId(@PathVariable long id, @RequestBody Imagen imagen){
		Imagen imagenPorId = imagenServicioImpl.obtenerPorId(id);
		 return ResponseEntity.ok(imagenPorId);
		 
	 }
	 
	 @PutMapping("/imagen/{id}")
	 public ResponseEntity<Imagen>actualizar(@PathVariable long id, @RequestBody Imagen imagen)
	 {
		 Imagen imagenPorId = imagenServicioImpl.obtenerPorId(id);
		 
		 imagenPorId.setUrl(imagen.getUrl());
		 imagenPorId.setProducto(imagen.getProducto());

		 
		 Imagen imagen_actualizada = imagenServicioImpl.guardarImagen(imagenPorId);
		 return new ResponseEntity<>(imagen_actualizada, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/imagen/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarImagen(@PathVariable long id)
	 {
		 this.imagenServicioImpl.eliminarImagen(id);
		 
		 HashMap<String, Boolean> estadoImagenEliminada = new HashMap<>();
		 estadoImagenEliminada.put("eliminada", true);
		 return ResponseEntity.ok(estadoImagenEliminada);
	 }	

}
