
package modelo.pojo;

public class Sucursal {

    private Integer idSucursal;
    private String nombre;
    private String telefono;
    private Double latitud;
    private Double longitud;
    private String nombreEncargado;
    private String empresaRFC;


    public Sucursal() {
    }

    public Sucursal(Integer idSucursal, String nombre, String telefono, Double latitud, Double longitud, String nombreEncargado, String empresaRFC) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombreEncargado = nombreEncargado;
        this.empresaRFC = empresaRFC;
      
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getEmpresaRFC() {
        return empresaRFC;
    }

    public void setEmpresaRFC(String empresaRFC) {
        this.empresaRFC = empresaRFC;
    }

}
