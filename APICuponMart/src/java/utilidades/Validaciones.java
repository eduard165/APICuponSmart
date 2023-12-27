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
                && empresa.getRfc().isEmpty()
                && empresa.getEmail().isEmpty()
                && empresa.getNombre_comercial().isEmpty()
                && empresa.getRepresentante_legal().isEmpty()
                && empresa.getTelefono().length() != 10
                && empresa.getPaginaWeb().isEmpty();

    }

    public static Boolean validarUsuario(Usuario usuario) {
        return usuario.getNombre().isEmpty()
                && usuario.getApellido_paterno().isEmpty()
                && usuario.getApellido_materno().isEmpty()
                && usuario.getCurp().isEmpty()
                && usuario.getCorreo_electronico().isEmpty()
                && usuario.getUsername().isEmpty()
                && usuario.getPassword().isEmpty()
                && usuario.getEmpresa_rfc().isEmpty();
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

    public static Boolean validarDireccion(Direccion direccion) {
        return direccion.getCalle().isEmpty()
                && direccion.getCodigo_postal().isEmpty()
                && direccion.getColonia().isEmpty()
                && direccion.getId_municipio() == null
                && direccion.getNumero() == null
                && validarTipoDireccion(direccion);
    }

    public static Boolean validarTipoDireccion(Direccion direccion) {
        if(direccion.getTipo_direccion() != null && direccion.getTipo_direccion() >0){
            switch (direccion.getTipo_direccion()) {
                case 1:
                    return direccion.getEmpresa_rfc() == null;
                case 2:
                    return direccion.getId_cliente() == null && direccion.getId_cliente() < 0;
                case 3:
                   return direccion.getId_sucursal() == null && direccion.getId_sucursal() < 0 ;
           default:
               return false;
            }       
        }else{
                   return false;
 
        }
        
        
    }
}
