package co.edu.uniquindio.unimarket.models;

public enum EstadoCarritoCompra 
{
	
    EN_PROCESO("En proceso"),
    COMPLETADO("Completado");

    private final String estado;

    EstadoCarritoCompra(String estado) 
    {
        this.estado = estado;
    }

    public String getEstado() 
    {
        return estado;
    }
}