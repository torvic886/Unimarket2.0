package co.edu.uniquindio.unimarket.services;

import java.util.List;


import co.edu.uniquindio.unimarket.models.Favorito;

public interface IFavoritoServicio {
	
	public List<Favorito> obtenerTodo();
	
	public Favorito guardarFavorito(Favorito favorito);
	
	public Favorito obtenerPorId(long id);
	
	public void eliminarFavorito(long id);		

}
