package modelo.pojo;

import java.time.LocalDate;

public class Cupon {

    private Integer id_cupon;
    private String codigo_cupon;
    private Integer id_promocion;
    private LocalDate fecha_generacion;
    private Integer id_estatus;

    public Cupon() {
    }

    public Cupon(Integer id_cupon, String codigo_cupon, Integer id_promocion, LocalDate fecha_generacion, Integer id_estaus) {
        this.id_cupon = id_cupon;
        this.codigo_cupon = codigo_cupon;
        this.id_promocion = id_promocion;
        this.fecha_generacion = fecha_generacion;
        this.id_estatus = id_estaus;
    }

    public Integer getId_cupon() {
        return id_cupon;
    }

    public void setId_cupon(Integer id_cupon) {
        this.id_cupon = id_cupon;
    }

    public String getCodigo_cupon() {
        return codigo_cupon;
    }

    public void setCodigo_cupon(String codigo_cupon) {
        this.codigo_cupon = codigo_cupon;
    }

    public Integer getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(Integer id_promocion) {
        this.id_promocion = id_promocion;
    }

    public LocalDate getFecha_generacion() {
        return fecha_generacion;
    }

    public void setFecha_generacion(LocalDate fecha_generacion) {
        this.fecha_generacion = fecha_generacion;
    }

    public Integer getId_estatus() {
        return id_estatus;
    }

    public void setId_estaus(Integer id_estaus) {
        this.id_estatus = id_estaus;
    }
}
