/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Categoria;
import modelo.pojo.Mensaje;
import modelo.pojo.Promocion;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class CategoriaDAO {

    public static List<Categoria> recuperarCategoriasDisponibles() {
        List<Categoria> categorias = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                categorias = sqlSession.selectList("categoria.obtenerCategorias");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return categorias;
    }

    


    public static List<Promocion> recuperarPromocionesPorCategoria(Integer id_categoria) {
        List<Promocion> promociones = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                promociones = sqlSession.selectList("categoria.buscarPromocionesPorCategoria", id_categoria);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return promociones;
    }


}
