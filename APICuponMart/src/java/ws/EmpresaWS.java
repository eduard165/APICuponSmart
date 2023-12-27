
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
import modelo.EmpresaDAO;
import modelo.pojo.Empresa;
import modelo.pojo.Mensaje;
import utilidades.Validaciones;

@Path("empresas")
public class EmpresaWS {

    public EmpresaWS() {
    }
    
    @Path("/agregar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje agregarEmpresa(String json) {
        Gson gson = new Gson();
        Empresa empresa = gson.fromJson(json, Empresa.class);
        if (Validaciones.validarEmpresa(empresa) ) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return EmpresaDAO.agregarEmpresa(empresa);
    }

    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarEmpresa(String json) {
        Gson gson = new Gson();
        Empresa empresa = gson.fromJson(json, Empresa.class);
        if (Validaciones.validarEmpresa(empresa)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return EmpresaDAO.editarEmpresa(empresa);
    }

    @Path("/eliminar/{empresaRFC}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarEmpresa(@PathParam("empresaRFC") String empresaRFC) {
        if (empresaRFC != null && !empresaRFC.isEmpty()) {
            return EmpresaDAO.eliminarEmpresa(empresaRFC);
        } else {
            return new Mensaje(true, "El RFC no puede estar vacío");
        }
    }

    @Path("/buscar/{parametro}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa buscarEmpresa(@PathParam("parametro") String parametro) {
        if (parametro == null || parametro.trim().isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return EmpresaDAO.buscarEmpresa(parametro);
    }

    @Path("/buscarEmpresas/{parametro}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> buscarEmpresas(@PathParam("parametro") String parametro) {
        if (parametro == null || parametro.trim().isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return EmpresaDAO.buscarEmpresas(parametro);
    }

    @PUT
    @Path("registrarLogo/{empresaRFC}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarFotografia(@PathParam("empresaRFC") String empresaRFC, byte[] foto) {
        if (empresaRFC == null && empresaRFC.isEmpty() && foto == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return EmpresaDAO.subirLogoPorId(empresaRFC, foto);
    }

    @GET
    @Path("obtenerLogo/{empresaRFC}")
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa ObtenerFotografia(@PathParam("empresaRFC") String empresaRFC) {
        if (empresaRFC == null && empresaRFC.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return EmpresaDAO.obtenerLogo(empresaRFC);
    }
}
