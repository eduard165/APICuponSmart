package modelo;

import java.util.ArrayList;
import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import modelo.pojo.Empresa;
import modelo.pojo.Mensaje;

public class EmpresaDAO {

    public static Mensaje agregarEmpresa(Empresa empresa) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.insert("empresa.agregarEmpresa", empresa);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Se agregó correctamente la empresa");
                } else {
                    msj.setMensaje("No se pudo agregar la empresa, intenta nuevamente");
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

    public static Mensaje editarEmpresa(Empresa empresa) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.update("empresa.editarEmpresa", empresa);
                sqlSession.commit();
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Se editó correctamente la empresa");
                } else {
                    msj.setMensaje("No se pudo editar la empresa, intenta nuevamente");
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

    public static Mensaje eliminarEmpresa(String RFC) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int sucursalesAsociadas = sqlSession.selectOne("empresa.contarSucursalesAsociadas", RFC);
                if (sucursalesAsociadas == 0) {
                    int filasAfectadas = sqlSession.delete("empresa.eliminarEmpresa", RFC);
                    sqlSession.commit();
                    if (filasAfectadas > 0) {
                        msj.setError(false);
                        msj.setMensaje("Se eliminó correctamente la empresa");
                    } else {
                        msj.setMensaje("No se pudo eliminar la empresa, intenta nuevamente");
                    }
                } else {
                    msj.setMensaje("No se puede eliminar la empresa. Tiene sucursales asociadas.");
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

    public static List<Empresa> buscarEmpresas(String parametro) {
        List<Empresa> empresas = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                empresas = sqlSession.selectList("empresa.buscarEmpresa", parametro);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return empresas;
    }

    public static Empresa buscarEmpresa(String parametro) {
        Empresa empresa = null;
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                empresa = sqlSession.selectOne("empresa.buscarEmpresa", parametro);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return empresa;
    }

    public static Mensaje subirLogoPorId(String rfc, byte[] logo) {
        Mensaje rest = new Mensaje();
        rest.setError(true);
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                Empresa empresaLogo = new Empresa();
                empresaLogo.setRfc(rfc);
                empresaLogo.setLogo(logo);
                int filasAfectadas = conexionBD.update("empresa.subirLogo", empresaLogo);
                conexionBD.commit();
                if (filasAfectadas > 0) {
                    rest.setError(false);
                    rest.setMensaje("El logo de la empresa a sido guardado correctamente");
                } else {
                    rest.setMensaje("Hubo un error al guardar el logo de la empresa, revise su archivo");
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

    public static Empresa obtenerLogo(String rfc) {
        Empresa empresa = null;
        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                empresa = conexionBD.selectOne("empresa.obtenerLogo", rfc);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexionBD.close();
            }
        }
        return empresa;
    }

    public static List<Empresa> cargarEmpresas() {
        List<Empresa> empresas = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                empresas = sqlSession.selectList("empresa.cargarEmpresas");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return empresas;
    }
}
