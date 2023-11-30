
package modelo;

import java.util.ArrayList;
import java.util.List;
import modelo.pojo.Cupon;
import modelo.pojo.Mensaje;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class CuponDAO {
    
    public static List<Cupon> listarCuponesDisponibles() {
    List<Cupon> cupones = new ArrayList<>();
    SqlSession sqlSession = MyBatisUtil.getSession();
    if (sqlSession != null) {
        try {
            cupones = sqlSession.selectList("cupon.listarCuponesDisponibles");
        } finally {
            sqlSession.close();
        }
    }
    return cupones;
}
    public static Mensaje canjearCupon(String codigoCupon) {
    Mensaje msj = new Mensaje();
    msj.setError(true);
    SqlSession sqlSession = MyBatisUtil.getSession();
    if (sqlSession != null) {
        try {
            int cuponesDisponibles = sqlSession.selectOne("cupon.obtenerCuponesDisponibles", codigoCupon);

            if (cuponesDisponibles > 0) {
                int filasAfectadas = sqlSession.update("cupon.canjearCupon", codigoCupon);
                sqlSession.commit();

                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Cupón canjeado correctamente");
                } else {
                    msj.setMensaje("No se pudo canjear el cupón, intenta nuevamente");
                }
            } else {
                msj.setMensaje("No hay cupones disponibles para canjear con el código proporcionado");
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


}
