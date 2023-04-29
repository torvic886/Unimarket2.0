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

import co.edu.uniquindio.unimarket.models.Categoria;
import co.edu.uniquindio.unimarket.services.CategoriaServicioImpl;

@RestController
@RequestMapping("/api/v5")
public class CategoriaController 
{
	@Autowired
	CategoriaServicioImpl categoriaServicioImpl;
	
	@GetMapping("/Categorias")
	public List<Categoria> obtenerCategoria(){
		return categoriaServicioImpl.obtenerTodo();	
	}
	
	@GetMapping("/categoria/{id}")	 
	public ResponseEntity<Categoria>guardarCategoria(@RequestBody Categoria categoria)
	{
		Categoria nueva_categoria = categoriaServicioImpl.guardarCategoria(categoria);
		 return new ResponseEntity<>(nueva_categoria, HttpStatus.CREATED);

	}
	
	 @PutMapping("/categoria/{id}")
	 public ResponseEntity<Categoria>actualizar(@PathVariable long id, @RequestBody Categoria categoria)
	 {
		 Categoria categoriaPorId = categoriaServicioImpl.obtenerPorId(id);

		 categoriaPorId.setNombre(categoria.getNombre());
		 categoriaPorId.setFechaCreacion(categoria.getFechaCreacion());
		 
		 Categoria categoria_actualizada = categoriaServicioImpl.guardarCategoria(categoriaPorId);

		 return new ResponseEntity<>(categoria_actualizada, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/categoria/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarCategoria(@PathVariable long id)
	 {
		 this.categoriaServicioImpl.eliminarCategoria(id);
		 
		 HashMap<String, Boolean> estadoCategoriaEliminado = new HashMap<>();
		 estadoCategoriaEliminado.put("eliminado", true);
		 return ResponseEntity.ok(estadoCategoriaEliminado);
	 }	
}
