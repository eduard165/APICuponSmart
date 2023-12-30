/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;
import modelo.pojo.Mensaje;
import modelo.pojo.MensajeUsuarios;
import modelo.pojo.Usuario;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author eduar
 */
public class UsuarioDAO {

    public static Mensaje registrarUsuario(Usuario usuario) {
        Mensaje msj = new Mensaje();
        Mensaje validacionesDuplicados = new Mensaje();
        msj.setError(true);

        validacionesDuplicados.setError(true);
        validacionesDuplicados = validarDuplicados(usuario.getUsername(), usuario.getCurp());

        if (!validacionesDuplicados.isError()) {
            switch (usuario.getId_rol()) {
                case 1:
                    msj = registrarUsuarioGeneral(usuario);
                    break;
                case 2:
                    msj = registrarUsuarioComercial(usuario);
                    break;

                default:
                    msj.setMensaje("Rol no válido");
                    break;
            }
            return msj;
        } else {
            return validacionesDuplicados;
        }
    }

    public static Mensaje editarUsuario(Usuario usuario) {
        Mensaje msj = new Mensaje();
        Mensaje validacionesDuplicados = new Mensaje();

        msj.setError(true);
        validacionesDuplicados.setError(true);

        validacionesDuplicados = validarDuplicados(usuario.getUsername(), usuario.getCurp());

        if (!validacionesDuplicados.isError()) {
            switch (usuario.getId_rol()) {
                case 1:
                    msj = editarUsuarioGeneral(usuario);
                    break;
                case 2:
                    msj = editarUsuarioComercial(usuario);
                    break;

                default:
                    msj.setMensaje("Rol no válido");
                    break;
            }
            return msj;
        } else {
            return validacionesDuplicados;
        }
    }

    private static Mensaje registrarUsuarioComercial(Usuario usuario) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.insert("usuario.agregarUsuarioComercial", usuario);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Usuario comercial registrado correctamente");
                } else {
                    msj.setMensaje("No se pudo registrar el usuario comercial, intenta nuevamente");
                }
            } catch (Exception e) {
                e.printStackTrace();
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return msj;
    }

    private static Mensaje registrarUsuarioGeneral(Usuario usuario) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.insert("usuario.agregarUsuarioGeneral", usuario);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Usuario general registrado correctamente");
                } else {
                    msj.setMensaje("No se pudo registrar el usuario general, intenta nuevamente");
                }
            } catch (Exception e) {
                e.printStackTrace();
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return msj;
    }

    private static Mensaje editarUsuarioComercial(Usuario usuario) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.update("usuario.editarUsuarioComercial", usuario);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Usuario comercial editado correctamente");
                } else {
                    msj.setMensaje("No se pudo editar el usuario comercial, intenta nuevamente");
                }
            } catch (Exception e) {
                e.printStackTrace();
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return msj;
    }

    private static Mensaje editarUsuarioGeneral(Usuario usuario) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.update("usuario.editarUsuarioGeneral", usuario);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Usuario general editado correctamente");
                } else {
                    msj.setMensaje("No se pudo editar el usuario general, intenta nuevamente");
                }
            } catch (Exception e) {
                e.printStackTrace();
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return msj;
    }

    public static Mensaje eliminarUsuario(Integer idUsuario) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.delete("usuario.eliminarUsuario", idUsuario);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Usuario eliminado correctamente");
                } else {
                    msj.setMensaje("No se pudo eliminar el usuario, intenta nuevamente");
                }
            } catch (Exception e) {
                e.printStackTrace();
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return msj;
    }

    public static List<Usuario> buscarUsuarios(String parametro) {
        List<Usuario> usuarios = null;
        SqlSession sqlSession = MyBatisUtil.getSession();

        if (sqlSession != null) {
            try {
                usuarios = sqlSession.selectList("usuario.buscarUsuario", parametro);
            } finally {
                sqlSession.close();
            }
        }

        return usuarios;
    }

    public static MensajeUsuarios cargarUsuarios() {
        MensajeUsuarios usuarios = new MensajeUsuarios();
        SqlSession sqlSession = MyBatisUtil.getSession();
        usuarios.setError(true);

        if (sqlSession != null) {
            try {
                usuarios.setUsuarios(sqlSession.selectList("usuario.cargarUsuarios"));
                usuarios.setError(false);
                usuarios.setMensaje("Todo salio bien");
            } finally {
                sqlSession.close();            }
        }else{
            usuarios.setMensaje("Algo salio mal");
        }

        return usuarios;
    }

    public static Mensaje validarDuplicados(String username, String curp) {
        Mensaje msj = new Mensaje();
        msj.setError(true);

        SqlSession sqlSession = MyBatisUtil.getSession();

        if (sqlSession != null) {
            try {
                Integer countUsername = sqlSession.selectOne("usuario.contarUsername", username);
                if (countUsername != null && countUsername > 0) {
                    msj.setMensaje("El username ya está en uso, por favor elige otro.");
                    return msj;
                }
                Integer countCurp = sqlSession.selectOne("usuario.contarCurp", curp);
                if (countCurp != null && countCurp > 0) {
                    msj.setMensaje("La CURP ya está en uso, por favor elige otra.");
                    return msj;
                }
                msj.setError(false);
            } catch (PersistenceException e) {
                e.printStackTrace();
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return msj;
    }
}
