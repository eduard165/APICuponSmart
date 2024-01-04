
package modelo.pojo;

public class TipoPromocion {
    private Integer id_tipo_promocion;
    private String nombre_tipo;

    public TipoPromocion() {
    }

    public TipoPromocion(Integer id_tipo_promocion, String nombre_tipo) {
        this.id_tipo_promocion = id_tipo_promocion;
        this.nombre_tipo = nombre_tipo;
    }

    public Integer getId_tipo_promocion() {
        return id_tipo_promocion;
    }

    public void setId_tipo_promocion(Integer id_tipo_promocion) {
        this.id_tipo_promocion = id_tipo_promocion;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }
    
    
}
