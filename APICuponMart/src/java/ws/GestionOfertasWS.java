
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
import modelo.CategoriaDAO;
import modelo.CuponDAO;
import modelo.EmpresaDAO;
import modelo.PromocionDAO;
import modelo.pojo.Categoria;
import modelo.pojo.Cupon;
import modelo.pojo.Empresa;
import modelo.pojo.Mensaje;
import modelo.pojo.Promocion;
import utilidades.Validaciones;

/**
 *
 * @author eduar
 */
@Path("GestionOfertas")
public class GestionOfertasWS {
    
    
    @GET
    @Path("/obtenerPromociones")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Promocion> buscarPromocion(@PathParam("parametro") String parametro) {
        if (parametro == null || parametro.trim().isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return PromocionDAO.buscarPromociones(parametro);
    }

    @POST
    @Path("/registrarPromocion")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarPromocionl(String json) {
        Gson gson = new Gson();
        Promocion promocion = gson.fromJson(json, Promocion.class);
        if (Validaciones.validarPromocion(promocion)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return PromocionDAO.registrarPromocion(promocion);
    }

    @PUT
    @Path("/editarPromocion")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje editarPromocion(String json) {
        Gson gson = new Gson();
        Promocion promocion = gson.fromJson(json, Promocion.class);
        if (Validaciones.validarPromocion(promocion)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return PromocionDAO.editarPromocion(promocion);
    }

    @PUT
    @Path("/editarEstadoPromocion/{idPromocion}/{nuevoEstado}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje editarEstadoDeLaPromocion(@PathParam("idPromocion") int id,
            @PathParam("nuevoEstado") int nuevoEstado) {
        if (id > 0 && nuevoEstado > 0 && nuevoEstado < 0) {
            return PromocionDAO.cambiarEstadoPromocion(id, nuevoEstado);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @GET
    @Path("obtenerPromociones/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Promocion> recuperarPromocionesEmpresa(@PathParam("id_categoria") Integer id_estatus) {
    
        return PromocionDAO.recuperarPromocionesDisponibles(id_estatus);
    }

    @DELETE
    @Path("/eliminarPromocion/{idPromocion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarPromocion(@PathParam("idPromocion") Integer idPromocion) {
        if (idPromocion < 0 && idPromocion == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return PromocionDAO.eliminarPromocion(idPromocion);
    }

    @PUT
    @Path("registrarFoto/{idPromocion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarFotografia(@PathParam("idPromocion") Integer idPromocion, byte[] foto) {
        if (idPromocion == null && idPromocion <= 0 && foto == null) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return PromocionDAO.subirImagenPorId(idPromocion, foto);
    }

    @GET
    @Path("obtenerFoto/{idPromocion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Promocion ObtenerFotografia(@PathParam("idPromocion") Integer idPromocion) {
        if (idPromocion == null && idPromocion <= 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return PromocionDAO.obtenerImagenPorId(idPromocion);
    }

    @GET
    @Path("obtenerCategorias")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> recuperarCategoriasDisponibles() {
        return CategoriaDAO.recuperarCategoriasDisponibles();
    }

  
    

    
   @GET
    @Path("PromocionesEmpresa/{id_categoria}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Promocion> recuperarPromocionesDeEmpresa(@PathParam("id_categoria") Integer id_categoria) {
    
        return PromocionDAO.recuperarPromocionesEmpresa(id_categoria);
    }

//////////////////////* CUPONES*//////////////////////////////////////////////
    @GET
    @Path("/cuponesDisponibles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cupon> cuponesDisponibles() {
        return CuponDAO.listarCuponesDisponibles();
    }

    @GET
    @Path("/cuponesDisponibles/{codigoCupon}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje cangearCupon(@PathParam("codigoCupon") String codigoCupon) {
        if (codigoCupon == null || codigoCupon.isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return CuponDAO.canjearCupon(codigoCupon);
    }
}
