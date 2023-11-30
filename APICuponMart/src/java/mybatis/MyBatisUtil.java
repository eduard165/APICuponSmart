/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybatis;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author eduar
 */
public class MyBatisUtil {
    
    // COMO BUENAS PRACTICAS TODAS LAS VARIABLES O ATRIBUTOS VAN EN MAYUSCULAS
    // FINAL SIGNIFICA QUE NO VA A CAMBIAR NI PUEDE SER MANIPULADA
    // STATIC ES UN METODO QUE NO NECESITA ESTANCIA 
    public static final String RESOURCE = "mybatis/mybatis-config.xml";
    public static final String ENVIROMENT="development";
    
    public static SqlSession getSession(){
        SqlSession session = null;
        
        try {
            
            Reader reader = Resources.getResourceAsReader(RESOURCE);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader, ENVIROMENT);
            session = sqlMapper.openSession();
                        
        } catch (IOException e){
            // el IOException muestra error cuando el try no tiene contenido ya que busca algo en concreto dentro del codigo 
            e.printStackTrace();
        }
        return session;
    } 
    
}
