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
        return empresa.getNombre().isEmpty()
                && empresa.getRFC().isEmpty()
                && empresa.getEmail().isEmpty()
                && empresa.getNombreComercial().isEmpty()
                && empresa.getRepresentanteLegal().isEmpty()
                && empresa.getTelefono().length() != 10
                && empresa.getPaginaWeb().isEmpty();

    }

    public static Boolean validarUsuario(Usuario usuario) {
        return usuario.getNombre().isEmpty()
                && usuario.getApellidoPaterno().isEmpty()
                && usuario.getApellidoMaterno().isEmpty()
                && usuario.getCURP().isEmpty()
                && usuario.getCorreoElectronico().isEmpty()
                && usuario.getUsername().isEmpty()
                && usuario.getPassword().isEmpty()
                && usuario.getEmpresaRFC().isEmpty();
    }

    public static Boolean ValidarInisioSesion(Usuario usuario) {
        return usuario.getUsername().isEmpty() && usuario.getPassword().isEmpty();
    }
  public static Boolean ValidarInisioSesion(Cliente cliente) {
        return cliente.getCorreoElectronico().isEmpty() &&cliente.getPassword().isEmpty();
    }

    public static Boolean validarSucursal(Sucursal sucursal) {
        return sucursal.getEmpresaRFC().isEmpty()
                && sucursal.getNombre().isEmpty()
                && sucursal.getTelefono().isEmpty()
                && sucursal.getNombreEncargado().isEmpty()
                && sucursal.getLatitud() == 0.0
                && sucursal.getLongitud() == 0.0;
    }

    public static boolean validarPromocion(Promocion promocion) {
        return promocion.getNombrePromocion().isEmpty()
                && promocion.getDescripcion().isEmpty()
                && promocion.getFechaInicio().isEmpty()
                && promocion.getFechaTermino().isEmpty()
                && promocion.getRestricciones().isEmpty()
                && promocion.getRestricciones().isEmpty()
                && promocion.getIdTipoPromocion() <= 0
                && promocion.getPorcentajeDescuento() == null
                && promocion.getCodigoPromocion().isEmpty()
                && promocion.getEmpresaRFC().isEmpty()
                && promocion.getIdCategoria() <= 0;
    }

    public static Boolean validarDireccion(Direccion direccion) {
        return direccion.getCalle().isEmpty()
                && direccion.getCodigoPostal().isEmpty()
                && direccion.getColonia().isEmpty()
                && direccion.getIdMunicipio() == null
                && direccion.getNumero() == null;
    }

    public static Integer validarTipoDireccion(Direccion direccion) {
        if (direccion.getEmpresaRFC() != null) {
            return 1;
        } else if (direccion.getIdCliente() != null) {
            return 2;
        } else if (direccion.getIdSucursal() != null) {
            return 3;
        } else {
            return 4;
        }
    }

}
