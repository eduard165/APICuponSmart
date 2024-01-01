
package ws;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.AutenticacionDAO;
import modelo.pojo.Cliente;
import modelo.pojo.RespuestaLoginCliente;
import modelo.pojo.RespuestaLoginUsuario;
import modelo.pojo.Usuario;
import utilidades.Validaciones;

/**
 *
 * @author eduar
 */
@Path("login")
public class AutenticacionWS {
    
    @POST
    @Path("/validacion/usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaLoginUsuario verificarUsuario(String json) {
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(json, Usuario.class);
       if(Validaciones.ValidarInisioSesion(usuario)){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
       }
         return  AutenticacionDAO.verificarSesionUsuario(usuario);
    }
    
    @POST
    @Path("/validacion/cliente")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaLoginCliente verificarCliente(@FormParam("correo_electronico") String correo_electronico,@FormParam("password") String password) {
      RespuestaLoginCliente respuesta  = null;
        // Gson gson = new Gson();
       // Cliente cliente = gson.fromJson(json, Cliente.class);
  //     if(Validaciones.ValidarInisioSesion(cliente)){
      //      throw new WebApplicationException(Response.Status.BAD_REQUEST);
       //}
       
        if (!correo_electronico.isEmpty() && !password.isEmpty()){
    
        respuesta = AutenticacionDAO.verificarSesionCliente(correo_electronico, password);
        }else{
        throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }
    

    return respuesta;
    
}
    
}
