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
import modelo.pojo.Mensaje;
import modelo.pojo.Usuario;
import modelo.UsuarioDAO;


import javax.ws.rs.Path;
import utilidades.Validaciones;

/**
 *
 * @author eduar
 */

    @Path("/usuarios")
public class UsuarioWS {

    @Path("/agregar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje agregarUsuario(String json) {
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(json, Usuario.class);
        if (Validaciones.validarUsuario(usuario)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        System.out.print(usuario);
        return UsuarioDAO.registrarUsuario(usuario);
    }

    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarUsuario(String json) {
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(json, Usuario.class);
       
        if (Validaciones.validarUsuario(usuario)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return UsuarioDAO.editarUsuario(usuario);
    }

    @Path("/eliminar/{idUsuario}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarUsuario(@PathParam("idUsuario") int idUsuario) {
        if (idUsuario <= 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return UsuarioDAO.eliminarUsuario(idUsuario);
    }

    @Path("/buscar/{parametro}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario buscarUsuario(@PathParam("parametro") String parametro) {
        if (parametro == null || parametro.trim().isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return UsuarioDAO.buscarUsuario(parametro);
    }
}


