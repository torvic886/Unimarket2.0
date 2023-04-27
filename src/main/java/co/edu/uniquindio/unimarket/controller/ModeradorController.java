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

import co.edu.uniquindio.unimarket.models.Moderador;
import co.edu.uniquindio.unimarket.services.ModeradorServicioImpl;

@RestController
@RequestMapping("/api/v3")
public class ModeradorController {
	
	   @Autowired
	    private ModeradorServicioImpl moderadorServicioImpl;
	    
	    
		@GetMapping("/Moderadores")
		public List<Moderador> obtenerModeradores(){
			return moderadorServicioImpl.obtenerTodo();	
		}
		
		
		 @PostMapping("/guardar")
		 public ResponseEntity<Moderador>guardarModerador(@RequestBody Moderador moderador) 
		 {
			 Moderador nuevo_moderador = moderadorServicioImpl.guardarModerador(moderador);
			 return new ResponseEntity<>(nuevo_moderador, HttpStatus.CREATED);
			 
		 }
		@GetMapping("/moderador/{id}")	 
		 public ResponseEntity<Moderador> obtenerModeradorId(@PathVariable long id, @RequestBody Moderador moderador){
			Moderador moderadorPorId = moderadorServicioImpl.obtenerPorId(id);
			 return ResponseEntity.ok(moderadorPorId);
			 
		 }
		 
		 @PutMapping("/moderador/{id}")
		 public ResponseEntity<Moderador>actualizar(@PathVariable long id, @RequestBody Moderador moderador)
		 {
			 Moderador moderadorPorId = moderadorServicioImpl.obtenerPorId(id);
			 
			 moderadorPorId.setNombreCompleto(moderador.getNombreCompleto());
			 moderadorPorId.setCedula(moderador.getCedula());
			 moderadorPorId.setEmail(moderador.getEmail());
			 moderadorPorId.setTelefono(moderador.getTelefono());
			 moderadorPorId.setContrasena(moderador.getContrasena());
			 moderadorPorId.setUsuario(moderador.getUsuario());
			 moderadorPorId.setProducto(moderador.getProducto());

			 
			 Moderador moderador_actualizado = moderadorServicioImpl.guardarModerador(moderadorPorId);
			 return new ResponseEntity<>(moderador_actualizado, HttpStatus.CREATED);
		 }
		 
		 @DeleteMapping("/producto/{id}")
		 public ResponseEntity<HashMap<String, Boolean>> eliminarModerador(@PathVariable long id)
		 {
			 this.moderadorServicioImpl.eliminarModerador(id);
			 
			 HashMap<String, Boolean> estadoModeradorEliminado = new HashMap<>();
			 estadoModeradorEliminado.put("eliminado", true);
			 return ResponseEntity.ok(estadoModeradorEliminado);
		 }

}
