package modelo.pojo;

public class RespuestaLoginUsuario {
    
    private boolean error;
    private String contenido;
    private Usuario usuario ;

    public RespuestaLoginUsuario() {
    }

    public RespuestaLoginUsuario(boolean error, String contenido, Usuario usuario) {
        this.error = error;
        this.contenido = contenido;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
