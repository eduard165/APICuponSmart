
package modelo.pojo;

public class TipoPromocion {
    private Integer idTipoPromocion;
    private String nombreTipo;

    public TipoPromocion() {
    }

    public TipoPromocion(Integer idTipoPromocion, String nombreTipo) {
        this.idTipoPromocion = idTipoPromocion;
        this.nombreTipo = nombreTipo;
    }

    public Integer getIdTipoPromocion() {
        return idTipoPromocion;
    }

    public void setIdTipoPromocion(Integer idTipoPromocion) {
        this.idTipoPromocion = idTipoPromocion;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    @Override
    public String toString() {
        return "- "+ nombreTipo ;
    }
    
}
