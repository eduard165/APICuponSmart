package modelo;

import java.util.List;
import modelo.pojo.Cliente;
import modelo.pojo.Direccion;
import modelo.pojo.Estado;
import modelo.pojo.Mensaje;
import modelo.pojo.Municipio;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import utilidades.Validaciones;

public class DireccionDAO {

    public static Mensaje agregarDomicilio(Direccion direccion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);

        switch (direccion.getTipo_direccion()) {
            case 1:
                msj = registrarDireccionEmpresa(direccion);
                break;
            case 2:
                msj = registrarDireccionCliente(direccion);
                break;
            case 3:
                msj = registrarDireccionSucursal(direccion);
                break;
            default:
                msj.setMensaje("ERROR: campos no válidos");
        }
        return msj;
    }

    public static Mensaje editarDomicilio(Direccion direccion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        
        switch (direccion.getTipo_direccion()) {
            case 1:
                msj = editarDireccionEmpresa(direccion);
                break;
            case 2:
                msj = editarDireccionCliente(direccion);
                break;
            case 3:
                msj = editarDireccionSucursal(direccion);
                break;
            default:
                msj.setMensaje("ERROR: campos no válidos");
        }
        return msj;
    }

    private static Mensaje registrarDireccionSucursal(Direccion direccion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.insert("direccion.agregarDireccionPorSucursal", direccion);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Direccion registrada correctamente");
                } else {
                    msj.setMensaje("No se pudo registrar la direccion de la sucursal, intenta nuevamente");
                }
            } catch (Exception e) {
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }else{
            msj.setMensaje("Por el momento no hay conexion para guardar el domicilio");
        }
        return msj;
    }

    private static Mensaje registrarDireccionEmpresa(Direccion direccion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.insert("direccion.agregarDireccionPorEmpresa", direccion);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Direccion registrada correctamente");
                } else {
                    msj.setMensaje("No se pudo registrar la direccion de la empresa, intenta nuevamente");
                }
            } catch (Exception e) {
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }else{
            msj.setMensaje("Por el momento no hay conexion para guardar el domicilio");
        }
        return msj;
    }

    private static Mensaje registrarDireccionCliente(Direccion direccion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.insert("direccion.agregarDireccionPorCliente", direccion);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Direccion registrada correctamente");
                } else {
                    msj.setMensaje("No se pudo registrar la direccion correctamente, intenta nuevamente");
                }
            } catch (Exception e) {
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }else{
            msj.setMensaje("Por el momento no hay conexion para guardar el domicilio");
        }
        return msj;
    }

    private static Mensaje editarDireccionSucursal(Direccion direccion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.update("direccion.editarDireccionPorSucursal", direccion);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Direccion editada correctamente");
                } else {
                    msj.setMensaje("No se pudo editar la direccion de la sucursal, intenta nuevamente");
                }
            } catch (Exception e) {
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }else{
            msj.setMensaje("Por el momento no hay conexion para actualizar el domicilio");
        }
        return msj;
    }

    private static Mensaje editarDireccionEmpresa(Direccion direccion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.insert("direccion.editarDireccionPorEmpresa", direccion);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Direccion editada correctamente");
                } else {
                    msj.setMensaje("No se pudo editar la direccion de la empresa, intenta nuevamente");
                }
            } catch (Exception e) {
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }else{
            msj.setMensaje("Por el momento no hay conexion para actualizar el domicilio");
        }
        return msj;
    }

    private static Mensaje editarDireccionCliente(Direccion direccion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.insert("direccion.editarDireccionPorCliente", direccion);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Direccion editada correctamente");
                } else {
                    msj.setMensaje("No se pudo editar la direccion correctamente, intenta nuevamente");
                }
            } catch (Exception e) {
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }else{
            msj.setMensaje("Por el momento no hay conexion para actualizar el domicilio");
        }
        return msj;
    }

    public static Direccion obtenerDomicilioEmpresa(String empresaRFC) {
        Direccion direccion = new Direccion();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                direccion = sqlSession.selectOne("domicilio.obtenerDireccionPorEmpresa", empresaRFC);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return direccion;
    }

    public static Direccion obtenerDomicilioCliente(Integer idCliente) {
        Direccion direccion = new Direccion();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                direccion = sqlSession.selectOne("domicilio.obtenerDireccionPorCliente", idCliente);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return direccion;
    }

    public static Direccion obtenerDomicilioSucursal(Integer idSucursal) {
        Direccion direccion = new Direccion();

        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                direccion = sqlSession.selectOne("domicilio.obtenerDireccionPorSucursal", idSucursal);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return direccion;
    }

    public static Mensaje eliminarDireccionCliente(Integer idCliente) {
        Mensaje mensaje = new Mensaje();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                Cliente cliente = sqlSession.selectOne("direccion.obtenerDireccionPorCliente", idCliente);
                if (cliente != null) {
                    int numeroDeFilasAfectadas = sqlSession.delete("direccion.eliminarDireccionPorCliente", idCliente);
                    sqlSession.commit();
                    if (numeroDeFilasAfectadas > 0) {
                        mensaje.setError(false);
                        mensaje.setMensaje("Paciente eliminado con éxito");
                    } else {
                        mensaje.setMensaje("No se pudo eliminar el Paciente");
                    }
                } else {
                    mensaje.setMensaje("Error: el usuario que desea eliminar no se encuntra en el sistema");
                }
            } catch (Exception e) {
                mensaje.setMensaje("Error: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return mensaje;
    }

    public static Mensaje eliminarDireccionEmpresa(String empresaRFC) {
        Mensaje mensaje = new Mensaje();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                Cliente cliente = sqlSession.selectOne("direccion.obtenerDireccionPorEmpresa", empresaRFC);
                if (cliente != null) {
                    int numeroDeFilasAfectadas = sqlSession.delete("direccion.eliminarDireccionPorCliente", empresaRFC);
                    sqlSession.commit();
                    if (numeroDeFilasAfectadas > 0) {
                        mensaje.setError(false);
                        mensaje.setMensaje("Direcccion eliminada con exito");
                    } else {
                        mensaje.setMensaje("No se pudo eliminar");
                    }
                } else {
                    mensaje.setMensaje("Error: la direccion que desea eliminar no se encuntra en el sistema");
                }
            } catch (Exception e) {
                mensaje.setMensaje("Error: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return mensaje;
    }

    public static Mensaje eliminarDireccionSucursal(Integer idSucursal) {
        Mensaje mensaje = new Mensaje();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                Cliente cliente = sqlSession.selectOne("direccion.obtenerDireccionPorCliente", idSucursal);
                if (cliente != null) {
                    int numeroDeFilasAfectadas = sqlSession.delete("direccion.eliminarDireccionPorSucursal", idSucursal);
                    sqlSession.commit();
                    if (numeroDeFilasAfectadas > 0) {
                        mensaje.setError(false);
                        mensaje.setMensaje("Direccion eliminada con éxito");
                    } else {
                        mensaje.setMensaje("No se pudo eliminar ");
                    }
                } else {
                    mensaje.setMensaje("Error: la direccion que desea eliminar no se encuntra en el sistema");
                }
            } catch (Exception e) {
                mensaje.setMensaje("Error: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return mensaje;
    }
     public static List<Estado> obtenerEstados() {
        List<Estado> estados = null;

        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                estados = conexionBD.selectList("direccion.obtenerEstados");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        }
        return estados;

    }

    public static  List<Municipio> obtenerMunicipios(int idEstado) {
        List<Municipio> municipios = null;
        SqlSession conexionDB = MyBatisUtil.getSession();
        if(conexionDB != null){
            try {
                  municipios= conexionDB.selectList("direccion.obtenerMunicipios", idEstado);
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                conexionDB.close();
            }
        }
        return municipios;
    }
}
