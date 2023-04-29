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

import co.edu.uniquindio.unimarket.models.Comentario;
import co.edu.uniquindio.unimarket.services.ComentarioServicioImpl;

@RestController
@RequestMapping("/api/v6")
public class ComentarioController 
{
	@Autowired
	ComentarioServicioImpl comentarioServicioImpl;
	
	
	@GetMapping("/Comentarios")
	public List<Comentario> obtenerComentarios(){
		return comentarioServicioImpl.obtenerTodo();	
	}
	
	
	 @PostMapping("/guardar")
	 public ResponseEntity<Comentario>guardarComentario(@RequestBody Comentario comentario) 
	 {
		 Comentario nuevo_comentario= comentarioServicioImpl.guardarComentario(comentario);
		 return new ResponseEntity<>(nuevo_comentario, HttpStatus.CREATED);
		 
	 }
	@GetMapping("/comentario/{id}")	 
	 public ResponseEntity<Comentario> obtenerComentarioId(@PathVariable long id, @RequestBody Comentario comentario){
		Comentario comentarioPorId = comentarioServicioImpl.obtenerPorId(id);
		 return ResponseEntity.ok(comentarioPorId);
		 
	 }
	 
	 @PutMapping("/comentario/{id}")
	 public ResponseEntity<Comentario>actualizar(@PathVariable long id, @RequestBody Comentario comentario)
	 {
		 Comentario comentarioPorId = comentarioServicioImpl.obtenerPorId(id);
		 
		 comentarioPorId.setComentario(comentario.getComentario());
		 comentarioPorId.setFechaCreacion(comentario.getFechaCreacion());
		 
		 Comentario producto_actualizado = comentarioServicioImpl.guardarComentario(comentarioPorId);
		 return new ResponseEntity<>(producto_actualizado, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/comentario/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarComentario(@PathVariable long id)
	 {
		 this.comentarioServicioImpl.eliminarComentario(id);
		 
		 HashMap<String, Boolean> estadoComentarioEliminado = new HashMap<>();
		 estadoComentarioEliminado.put("eliminado", true);
		 return ResponseEntity.ok(estadoComentarioEliminado);
	 }	

}
