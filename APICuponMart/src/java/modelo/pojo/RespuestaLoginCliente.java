package modelo.pojo;

public class RespuestaLoginCliente {
    
    private boolean error;
    private String contenido;
    private Cliente cliente ;

    public RespuestaLoginCliente() {
    }

    public RespuestaLoginCliente(boolean error, String contenido, Cliente cliente) {
        this.error = error;
        this.contenido = contenido;
        this.cliente = cliente;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
