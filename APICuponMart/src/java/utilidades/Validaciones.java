/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import modelo.pojo.Cliente;
import modelo.pojo.Direccion;
import modelo.pojo.Empresa;
import modelo.pojo.Promocion;
import modelo.pojo.Sucursal;
import modelo.pojo.Usuario;

/**
 *
 * @author eduar
 */
public class Validaciones {

    public static Boolean validarEmpresa(Empresa empresa) {
        return (empresa.getNombre() == null || empresa.getNombre().isEmpty())
                && (empresa.getRfc() == null || empresa.getRfc().isEmpty())
                && (empresa.getEmail() == null || empresa.getEmail().isEmpty())
                && (empresa.getNombre_comercial() == null || empresa.getNombre_comercial().isEmpty())
                && (empresa.getRepresentante_legal() == null || empresa.getRepresentante_legal().isEmpty())
                && (empresa.getTelefono() == null || empresa.getTelefono().length() != 10)
                && (empresa.getPagina_web() == null || empresa.getPagina_web().isEmpty());
    }

    public static Boolean validarUsuario(Usuario usuario) {
        boolean camposComunesVacios = (usuario.getNombre() == null || usuario.getNombre().isEmpty())
                || (usuario.getApellido_paterno() == null || usuario.getApellido_paterno().isEmpty())
                || (usuario.getApellido_materno() == null || usuario.getApellido_materno().isEmpty())
                || (usuario.getCurp() == null || usuario.getCurp().isEmpty())
                || (usuario.getCorreo_electronico() == null || usuario.getCorreo_electronico().isEmpty())
                || (usuario.getUsername() == null || usuario.getUsername().isEmpty())
                || (usuario.getPassword() == null || usuario.getPassword().isEmpty());

        if (usuario.getId_rol() == 2) {
            return camposComunesVacios && (usuario.getEmpresa_rfc() == null || usuario.getEmpresa_rfc().isEmpty());
        } else {
            return camposComunesVacios;
        }
    }

    public static boolean validarCliente(Cliente cliente) {
        boolean camposVacios = (cliente.getNombre() == null || cliente.getNombre().isEmpty())
                || (cliente.getApellido_paterno() == null || cliente.getApellido_paterno().isEmpty())
                || (cliente.getApellido_materno() == null || cliente.getApellido_materno().isEmpty())
                || (cliente.getTelefono() == null || cliente.getTelefono().isEmpty())
                || (cliente.getPassword() == null || cliente.getPassword().isEmpty());

        return camposVacios;
    }

    public static Boolean ValidarInisioSesion(Usuario usuario) {
        return usuario.getUsername().isEmpty() && usuario.getPassword().isEmpty();
    }

    public static Boolean ValidarInisioSesion(Cliente cliente) {
        return cliente.getCorreo_electronico().isEmpty() && cliente.getPassword().isEmpty();
    }

    public static Boolean validarSucursal(Sucursal sucursal) {
        return sucursal.getEmpresa_rfc().isEmpty()
                && sucursal.getNombre().isEmpty()
                && sucursal.getTelefono().isEmpty()
                && sucursal.getNombre_encargado().isEmpty()
                && sucursal.getLatitud() == 0.0
                && sucursal.getLongitud() == 0.0;
    }

    public static boolean validarPromocion(Promocion promocion) {
        return promocion.getNombre_promocion().isEmpty()
                && promocion.getDescripcion().isEmpty()
                && promocion.getFecha_inicio().isEmpty()
                && promocion.getFecha_termino().isEmpty()
                && promocion.getRestricciones().isEmpty()
                && promocion.getRestricciones().isEmpty()
                && promocion.getId_tipo_promocion() <= 0
                && promocion.getPorcentaje_descuento() == null
                && promocion.getCodigo_promocion().isEmpty()
                && promocion.getEmpresa_rfc().isEmpty()
                && promocion.getId_categoria() <= 0;
    }


    public static boolean validarTipoDireccion(Direccion direccion) {
    boolean camposComunesLlenos = direccion.getCalle() != null
            && direccion.getCodigo_postal() != null
            && direccion.getColonia() != null
            && direccion.getId_municipio() != null
            && direccion.getNumero() != null;

    if (direccion.getTipo_direccion() != null && direccion.getTipo_direccion() > 0 && direccion.getTipo_direccion() < 4) {
        switch (direccion.getTipo_direccion()) {
            case 1:
                return camposComunesLlenos && direccion.getEmpresa_rfc() != null
                        && (direccion.getId_cliente() == null && direccion.getId_sucursal() == null);
            case 2:
                return camposComunesLlenos && direccion.getId_cliente() != null
                        && (direccion.getEmpresa_rfc() == null && direccion.getId_sucursal() == null);
            case 3:
                return camposComunesLlenos && direccion.getId_sucursal() != null
                        && (direccion.getId_cliente() == null && direccion.getEmpresa_rfc() == null);
            default:
                return false;
        }
    } else {
        return false;
    }
}


}
