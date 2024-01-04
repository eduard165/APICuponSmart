/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.pojo.Mensaje;
import modelo.pojo.Promocion;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author eduar
 */
public class PromocionDAO {

    public static Mensaje registrarPromocion(Promocion promocion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadasPromocion = sqlSession.insert("promocion.agregarPromocion", promocion);
                if (filasAfectadasPromocion > 0) {
                    Promocion promocion2 = sqlSession.selectOne("promocion.buscarPorCodigoPromocion", promocion.getCodigo_promocion());
                    promocion2.setId_sucursal(promocion.getId_sucursal());

                    if (promocion2.getId_promocion() != 0 && promocion2.getId_sucursal() != 0) {
                        int filasAfectadasSucursalPromocion = sqlSession.insert("promocion.insertarEnSucursalPromocion", promocion2);
                        if (filasAfectadasSucursalPromocion > 0) {
                            msj.setError(false);
                            msj.setMensaje("Promoción registrada correctamente");
                        } else {
                            msj.setMensaje("No se pudo registrar la promoción en sucursal_promocion, intenta nuevamente");
                        }
                    } else {
                        msj.setMensaje("No se pudo obtener el ID de la promoción registrada");
                    }
                } else {
                    msj.setMensaje("No se pudo registrar la promoción, intenta nuevamente");
                }

                sqlSession.commit();
            } catch (Exception e) {
                e.printStackTrace();
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return msj;
    }

    public static Mensaje editarPromocion(Promocion promocion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.update("promocion.editarPromocion", promocion);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Promoción editada correctamente");
                } else {
                    msj.setMensaje("No se pudo editar la promoción, intenta nuevamente");
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

    public static Mensaje eliminarPromocion(Integer idPromocion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.delete("promocion.eliminarPromocion", idPromocion);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Promoción eliminada correctamente");
                } else {
                    msj.setMensaje("No se pudo eliminar la promoción, intenta nuevamente");
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

    public static Mensaje cambiarEstadoPromocion(Integer idPromocion, Integer nuevoEstatusID) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("idPromocion", idPromocion);
                parameters.put("nuevoEstatusID", nuevoEstatusID);

                int filasAfectadas = sqlSession.update("promocion.cambiarEstadoPromocion", parameters);

                sqlSession.commit();

                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Estado de la promoción cambiado correctamente");
                } else {
                    msj.setMensaje("No se pudo cambiar el estado de la promoción, intenta nuevamente");
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

    public static List<Promocion> buscarPromociones(String parametro) {
        List<Promocion> promociones = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtil.getSession();

        if (sqlSession != null) {
            try {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("param", parametro);
                promociones = sqlSession.selectList("promocion.buscarPromociones", parameters);
            } finally {
                sqlSession.close();
            }
        }
        return promociones;
    }

    public static Mensaje subirImagenPorId(int idPromocion, byte[] foto) {
        Mensaje rest = new Mensaje();
        rest.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                Promocion promocionFoto = new Promocion();
                promocionFoto.setId_promocion(idPromocion);
                promocionFoto.setImagen(foto);
                int filasAfectadas = conexionBD.update("promocion.subirImagen", promocionFoto);
                conexionBD.commit();
                if (filasAfectadas > 0) {
                    rest.setError(false);
                    rest.setMensaje("La imagen de la promocion a sido guardada correctamente");
                } else {
                    rest.setMensaje("Hubo un error al guardar la imagen de la promocion, revise su imagen");
                }
            } catch (Exception e) {
                rest.setMensaje("Error: " + e.getMessage());
            } finally {
                conexionBD.close();
            }
        } else {
            rest.setMensaje("Lo sentimos no hay conexion para guardar la imgen de la promocion");
        }
        return rest;
    }

    public static Promocion obtenerImagenPorId(int idPromocion) {
        Promocion promocion = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                promocion = conexionBD.selectOne("promocion.obtenerimagen", idPromocion);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        }
        return promocion;
    }

    public static List<Promocion> recuperarPromocionesPorCategoria(Integer id_categoria) {
        List<Promocion> promociones = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                promociones = sqlSession.selectList("promocion.buscarPromocionesPorCategoria", id_categoria);
                sqlSession.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return promociones;
    }

    public static List<Promocion> recuperarPromocionesEmpresa(Integer id_categoria) {
        List<Promocion> promociones = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                promociones = sqlSession.selectList("promocion.obtenerPromocionesEmpresa", id_categoria);
                sqlSession.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return promociones;
    }

    public static List<Promocion> cargarPromociones() {
        List<Promocion> promociones = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                promociones = sqlSession.selectList("promocion.cargarPromociones");
                sqlSession.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return promociones;
    }

}
