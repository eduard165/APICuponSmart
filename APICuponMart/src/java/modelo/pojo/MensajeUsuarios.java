
package modelo.pojo;

import java.util.List;

public class MensajeUsuarios {
    private boolean error;
    private String mensaje;
    List<Usuario> usuarios;

    public MensajeUsuarios() {
    }

    public MensajeUsuarios(boolean error, String mensaje, List<Usuario> usuarios) {
        this.error = error;
        this.mensaje = mensaje;
        this.usuarios = usuarios;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
