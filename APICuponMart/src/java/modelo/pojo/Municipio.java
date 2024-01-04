/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

/**
 *
 * @author eduar
 */
public class Municipio {
    
    private Integer id_municipio;
    private Integer id_estado;
    private String nombre;

    public Municipio() {
    }

    public Municipio(Integer id_municipio, Integer id_estado, String nombre) {
        this.id_municipio = id_municipio;
        this.id_estado = id_estado;
        this.nombre = nombre;
    }

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
