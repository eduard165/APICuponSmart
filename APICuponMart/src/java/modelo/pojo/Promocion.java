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

    private Integer idPromocion;
    private String nombrePromocion;
    private String descripcion;
    private byte[] imagen;
    private String imagenBase64;
    private String fechaInicio;
    private String fechaTermino;
    private String restricciones;
    private Integer idTipoPromocion;
    private BigDecimal porcentajeDescuento;
    private String codigoPromocion;
    private String empresaRFC;
    private Integer idCategoria;
    private Integer idEstatus;

    public Promocion() {
    }

    public Promocion(Integer idPromocion, String nombrePromocion, String descripcion, byte[] imagen, String imagenBase64, String fechaInicio, String fechaTermino, String restricciones, Integer idTipoPromocion, BigDecimal porcentajeDescuento, String codigoPromocion, String empresaRFC, Integer idCategoria, Integer idEstatus) {
        this.idPromocion = idPromocion;
        this.nombrePromocion = nombrePromocion;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.imagenBase64 = imagenBase64;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.restricciones = restricciones;
        this.idTipoPromocion = idTipoPromocion;
        this.porcentajeDescuento = porcentajeDescuento;
        this.codigoPromocion = codigoPromocion;
        this.empresaRFC = empresaRFC;
        this.idCategoria = idCategoria;
        this.idEstatus = idEstatus;
    }

    public Integer getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        this.nombrePromocion = nombrePromocion;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public Integer getIdTipoPromocion() {
        return idTipoPromocion;
    }

    public void setIdTipoPromocion(Integer idTipoPromocion) {
        this.idTipoPromocion = idTipoPromocion;
    }

    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getCodigoPromocion() {
        return codigoPromocion;
    }

    public void setCodigoPromocion(String codigoPromocion) {
        this.codigoPromocion = codigoPromocion;
    }

    public String getEmpresaRFC() {
        return empresaRFC;
    }

    public void setEmpresaRFC(String empresaRFC) {
        this.empresaRFC = empresaRFC;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }


   

}
