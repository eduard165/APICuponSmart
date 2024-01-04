
package ws;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.ClienteDAO;
import modelo.UsuarioDAO;
import modelo.pojo.Cliente;
import modelo.pojo.Mensaje;
import utilidades.Validaciones;

    @Path("/clientes")
public class ClienteWS {
    @POST
    @Path("/agregar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje agregarCliente(String json) {
        Gson gson = new Gson();
        Cliente cliente = gson.fromJson(json, Cliente.class);
        if (Validaciones.validarCliente(cliente)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ClienteDAO.registrarCliente(cliente);
    }

    @PUT
    @Path("/editar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarCliente(String json) {
        Gson gson = new Gson();
        Cliente cliente = gson.fromJson(json, Cliente.class);
        if (Validaciones.validarCliente(cliente)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ClienteDAO.editarCliente(cliente);
    }

    @DELETE
    @Path("/eliminar/{idCliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarCliente(@PathParam("idCliente") int idCliente) {
        if (idCliente <= 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ClienteDAO.eliminarCliente(idCliente);
    }

    @GET
    @Path("/buscar/{parametro}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> buscarClientes(@PathParam("parametro") String parametro) {
        if (parametro == null || parametro.trim().isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return ClienteDAO.buscarClientes(parametro);
    }

}
