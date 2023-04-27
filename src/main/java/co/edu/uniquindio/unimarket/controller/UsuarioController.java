package co.edu.uniquindio.unimarket.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniquindio.unimarket.models.Usuario;
import co.edu.uniquindio.unimarket.services.UsuarioServicioImpl;



@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	
	

	@Autowired
	UsuarioServicioImpl usuarioservicioimpl;
	
	
	@GetMapping("/Usuarios")
	public List<Usuario> obtenerClientes(){
		return usuarioservicioimpl.obtenerTodo();	
	}
	
	
	 @PostMapping("/guardar")
	 public ResponseEntity<Usuario>guardarUsuario(@RequestBody Usuario usuario) 
	 {
		 System.out.println(usuario);
		 Usuario nuevo_usuario = usuarioservicioimpl.guardarUsuario(usuario);
		 return new ResponseEntity<>(nuevo_usuario, HttpStatus.CREATED);
		 
	 }
	@GetMapping("/usuario/{id}")	 
	 public ResponseEntity<Usuario> obtenerUsuarioId(@PathVariable long id, @RequestBody Usuario usuario){
		 Usuario usuarioPorId = usuarioservicioimpl.obtenerPorId(id);
		 return ResponseEntity.ok(usuarioPorId);
		 
	 }
	 
	 @PutMapping("/usuario/{id}")
	 public ResponseEntity<Usuario>actualizar(@PathVariable long id, @RequestBody Usuario usuario)
	 {
		 Usuario usuarioPorId = usuarioservicioimpl.obtenerPorId(id);
		 System.out.println(usuarioPorId);
		 
		 usuarioPorId.setNombreCompleto(usuario.getNombreCompleto());
		 usuarioPorId.setCedula(usuario.getCedula());
		 usuarioPorId.setTelefono(usuario.getTelefono());
		 usuarioPorId.setDireccion(usuario.getDireccion());
		 usuarioPorId.setEmail(usuario.getEmail());
		 usuarioPorId.setContrasena(usuario.getContrasena());
		 
		 Usuario usuario_actualizado = usuarioservicioimpl.guardarUsuario(usuarioPorId);
		 return new ResponseEntity<>(usuario_actualizado, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/usuario/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarCliente(@PathVariable long id)
	 {
		 this.usuarioservicioimpl.eliminarUsuario(id);
		 
		 HashMap<String, Boolean> estadoUsuarioEliminado = new HashMap<>();
		 estadoUsuarioEliminado.put("eliminado", true);
		 return ResponseEntity.ok(estadoUsuarioEliminado);
	 }	

}
