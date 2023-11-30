
package modelo.pojo;

import java.time.LocalDate;

public class Cupon {
    private Integer idCupon;
    private String codigoCupon;
    private Integer idPromocion;
     private LocalDate fechaGeneracion;
     private Integer idEstaus;

    public Cupon() {
    }

    public Cupon(Integer idCupon, String codigoCupon, Integer idPromocion, LocalDate fechaGeneracion, Integer idEstaus) {
        this.idCupon = idCupon;
        this.codigoCupon = codigoCupon;
        this.idPromocion = idPromocion;
        this.fechaGeneracion = fechaGeneracion;
        this.idEstaus = idEstaus;
    }

    public Integer getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(Integer idCupon) {
        this.idCupon = idCupon;
    }

    public String getCodigoCupon() {
        return codigoCupon;
    }

    public void setCodigoCupon(String codigoCupon) {
        this.codigoCupon = codigoCupon;
    }

    public Integer getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(Integer idPromocion) {
        this.idPromocion = idPromocion;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Integer getIdEstaus() {
        return idEstaus;
    }

    public void setIdEstaus(Integer idEstaus) {
        this.idEstaus = idEstaus;
    }

}
