/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import java.util.List;
import modelo.pojo.Mensaje;
import modelo.pojo.Usuario;
import modelo.UsuarioDAO;

import javax.ws.rs.Path;
import modelo.pojo.MensajeUsuarios;
import utilidades.Validaciones;

/**
 *
 * @author eduar
 */
@Path("usuarios")
public class UsuarioWS {

    @Path("agregar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje agregarUsuario(String json) {
        Gson gson = new Gson();
        Usuario usuario = new Usuario();
        usuario = gson.fromJson(json, Usuario.class);
        if (Validaciones.validarUsuario(usuario)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return UsuarioDAO.registrarUsuario(usuario);
    }

    @Path("editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarUsuario(String json) {
        Gson gson = new Gson();
        Usuario usuario = new Usuario();
        usuario = gson.fromJson(json, Usuario.class);

        if (Validaciones.validarUsuario(usuario)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return UsuarioDAO.editarUsuario(usuario);
    }

    @Path("eliminar")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarUsuario(@FormParam("id_usuario") Integer id_usuario) {
        if (id_usuario <= 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return UsuarioDAO.eliminarUsuario(id_usuario);
    }

    @Path("buscar/{parametro}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> buscarUsuario(@PathParam("parametro") String parametro) {
        if (parametro == null || parametro.trim().isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return UsuarioDAO.buscarUsuarios(parametro);
    }

    @Path("cargarUsuarios/{id_usuario}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MensajeUsuarios cargarUsuarios(@PathParam("id_usuario") Integer id_usuario) {

        return UsuarioDAO.cargarUsuarios(id_usuario);
    }
}
