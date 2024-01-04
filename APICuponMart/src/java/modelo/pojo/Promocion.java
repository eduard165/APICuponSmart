/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author eduar
 */
public class Promocion {

    private Integer id_promocion;
    private String nombre_promocion;
    private String descripcion;
    private byte[] imagen;
    private String imagenBase64;
    private String fecha_inicio;
    private String fecha_termino;
    private String restricciones;
    private Integer id_tipo_promocion;
    private BigDecimal porcentaje_descuento;
    private String codigo_promocion;
    private String empresa_rfc;
    private String nombre_empresa;
    private String nombre_tipo;
    private Integer id_categoria;
    private Integer id_estatus;
    

    public Promocion() {
    }

    public Promocion(Integer id_promocion, String nombre_promocion, String descripcion, byte[] imagen, String imagenBase64, String fecha_inicio, String fecha_termino, String restricciones, Integer id_tipo_promocion, BigDecimal porcentaje_descuento, String codigo_promocion, String empresa_rfc, String nombre_empresa, String nombre_tipo, Integer id_categoria, Integer id_estatus) {
        this.id_promocion = id_promocion;
        this.nombre_promocion = nombre_promocion;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.imagenBase64 = imagenBase64;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.restricciones = restricciones;
        this.id_tipo_promocion = id_tipo_promocion;
        this.porcentaje_descuento = porcentaje_descuento;
        this.codigo_promocion = codigo_promocion;
        this.empresa_rfc = empresa_rfc;
        this.nombre_empresa = nombre_empresa;
        this.nombre_tipo = nombre_tipo;
        this.id_categoria = id_categoria;
        this.id_estatus = id_estatus;
    }


    public Integer getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(Integer id_promocion) {
        this.id_promocion = id_promocion;
    }

    public String getNombre_promocion() {
        return nombre_promocion;
    }

    public void setNombre_promocion(String nombre_promocion) {
        this.nombre_promocion = nombre_promocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getImagenBase64() {
        return imagenBase64;
    }

    public void setImagenBase64(String imagenBase64) {
        this.imagenBase64 = imagenBase64;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(String fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public Integer getId_tipo_promocion() {
        return id_tipo_promocion;
    }

    public void setId_tipo_promocion(Integer id_tipo_promocion) {
        this.id_tipo_promocion = id_tipo_promocion;
    }

    public BigDecimal getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(BigDecimal porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public String getCodigo_promocion() {
        return codigo_promocion;
    }

    public void setCodigo_promocion(String codigo_promocion) {
        this.codigo_promocion = codigo_promocion;
    }

    public String getEmpresa_rfc() {
        return empresa_rfc;
    }

    public void setEmpresa_rfc(String empresa_rfc) {
        this.empresa_rfc = empresa_rfc;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Integer getId_estatus() {
        return id_estatus;
    }

    public void setId_estatus(Integer id_estatus) {
        this.id_estatus = id_estatus;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }
    
}
