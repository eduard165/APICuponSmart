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
import modelo.DireccionDAO;
import modelo.pojo.Direccion;
import modelo.pojo.Estado;
import modelo.pojo.Mensaje;
import modelo.pojo.Municipio;
import utilidades.Validaciones;

@Path("direccion")
public class DireccionWS {

    @Path("registrarDireccion")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje agregarDomicilio(String json) {
        Gson gson = new Gson();
        Direccion direccion = gson.fromJson(json, Direccion.class);
        if (Validaciones.validarDireccion(direccion)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return DireccionDAO.agregarDomicilio(direccion);
    }

    @Path("editarDireccion")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarDireccion(String json) {
        Gson gson = new Gson();
        Direccion direccion = gson.fromJson(json, Direccion.class);
        if (Validaciones.validarDireccion(direccion)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return DireccionDAO.editarDomicilio(direccion);
    }

    @Path("buscar/empresa/{empresaRFC}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Direccion buscarDireccionEmpresa(@PathParam("parametro") String empresaRFC) {
        if (empresaRFC == null || empresaRFC.trim().isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return DireccionDAO.obtenerDomicilioEmpresa(empresaRFC);
    }

    @Path("/buscar/cliente/{idCliente}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Direccion buscarDireccionCliente(@PathParam("parametro") Integer idCliente) {
        if (idCliente == null || idCliente <= 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return DireccionDAO.obtenerDomicilioCliente(idCliente);
    }

    @Path("buscar/sucursal/idSucursal}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Direccion buscarEmpresa(@PathParam("parametro") Integer idSucursal) {
        if (idSucursal == null || idSucursal <= 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return DireccionDAO.obtenerDomicilioSucursal(idSucursal);
    }

    @Path("eliminar/empresa/{empresaRFC}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarEmpresa(@PathParam("empresaRFC") String empresaRFC) {
        if (empresaRFC != null && !empresaRFC.isEmpty()) {
            return DireccionDAO.eliminarDireccionEmpresa(empresaRFC);
        } else {
            return new Mensaje(true, "Campo vacío");
        }
    }

    @Path("eliminar/cliente/{idCliente}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarDireccionCliente(@PathParam("idCliente") Integer idCliente) {
        if (idCliente != null && idCliente > 0) {
            return DireccionDAO.eliminarDireccionCliente(idCliente);
        } else {
            return new Mensaje(true, "Campo vacío");
        }
    }

    @Path("eliminar/sucursal/{idSucursal}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarDireccionSucursal(@PathParam("idSucursal") Integer idSucursal) {
        if (idSucursal != null && idSucursal > 0) {
            return DireccionDAO.eliminarDireccionSucursal(idSucursal);
        } else {
            return new Mensaje(true, "Campo vacío");
        }
    }

    @Path("obtenerEstados")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> obtenerDomicilioPaciente() {
        return DireccionDAO.obtenerEstados();
    }

    @Path("obtenerMunicipios/{idEstado}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Municipio> buscarEmpresa(@PathParam("idEstado") int idEstado) {
        return DireccionDAO.obtenerMunicipios(idEstado);
    }
}
