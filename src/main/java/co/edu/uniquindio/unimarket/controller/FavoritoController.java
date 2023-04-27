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


import co.edu.uniquindio.unimarket.models.Favorito;
import co.edu.uniquindio.unimarket.services.FavoritoServicioImpl;

@RestController
@RequestMapping("/api/v13")
public class FavoritoController {
	
	@Autowired
	FavoritoServicioImpl favoritoServicioImpl;
	
	
	@GetMapping("/Favoritos")
	public List<Favorito> obtenerFavoritos(){
		return favoritoServicioImpl.obtenerTodo();	
	}
	
	
	 @PostMapping("/guardar")
	 public ResponseEntity<Favorito>guardarFavorito(@RequestBody Favorito favorito) 
	 {
		 Favorito nuevo_favorito= favoritoServicioImpl.guardarFavorito(favorito);
		 return new ResponseEntity<>(nuevo_favorito, HttpStatus.CREATED);
		 
	 }
	@GetMapping("/favorito/{id}")	 
	 public ResponseEntity<Favorito> obtenerFavoritoId(@PathVariable long id, @RequestBody Favorito favorito){
		Favorito favoritoPorId = favoritoServicioImpl.obtenerPorId(id);
		 return ResponseEntity.ok(favoritoPorId);
		 
	 }
	 
	 @PutMapping("/favorito/{id}")
	 public ResponseEntity<Favorito>actualizar(@PathVariable long id, @RequestBody Favorito favorito)
	 {
		 Favorito favoritoPorId = favoritoServicioImpl.obtenerPorId(id);
		 
		 favoritoPorId.setNombreProducto(favorito.getNombreProducto());


		 
		 Favorito favorito_actualizado = favoritoServicioImpl.guardarFavorito(favoritoPorId);
		 return new ResponseEntity<>(favorito_actualizado, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/favorito/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarFavorito(@PathVariable long id)
	 {
		 this.favoritoServicioImpl.eliminarFavorito(id);
		 
		 HashMap<String, Boolean> estadoFavoritoEliminada = new HashMap<>();
		 estadoFavoritoEliminada.put("eliminada", true);
		 return ResponseEntity.ok(estadoFavoritoEliminada);
	 }		

}
