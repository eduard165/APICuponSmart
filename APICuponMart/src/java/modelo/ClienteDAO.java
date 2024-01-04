/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import modelo.pojo.Cliente;
import modelo.pojo.Mensaje;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class ClienteDAO {

    public static Mensaje registrarCliente(Cliente cliente) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();

        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.insert("cliente.insertarCliente", cliente);
                sqlSession.commit();

                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Cliente registrado correctamente");
                } else {
                    msj.setMensaje("No se pudo registrar el cliente, intenta nuevamente");
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

    public static Mensaje editarCliente(Cliente cliente) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();

        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.update("cliente.editarCliente", cliente);
                sqlSession.commit();

                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Cliente editado correctamente");
                } else {
                    msj.setMensaje("No se pudo editar el cliente, intenta nuevamente");
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

    public static Mensaje eliminarCliente(Integer idCliente) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();

        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.delete("cliente.eliminarCliente", idCliente);
                sqlSession.commit();

                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Cliente eliminado correctamente");
                } else {
                    msj.setMensaje("No se pudo eliminar el cliente, intenta nuevamente");
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

    public static List<Cliente> buscarClientes(String parametro) {
        List<Cliente> clientes = null;
        SqlSession sqlSession = MyBatisUtil.getSession();

        if (sqlSession != null) {
            try {
                clientes = sqlSession.selectList("cliente.obtenerClientePorId", parametro);
            } finally {
                sqlSession.close();
            }
        }

        return clientes;
    }

}
