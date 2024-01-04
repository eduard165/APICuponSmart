
package modelo.pojo;

public class Sucursal {

    private Integer id_sucursal;
    private String nombre;
    private String telefono;
    private Double latitud;
    private Double longitud;
    private String nombre_encargado;
    private String empresa_rfc;
    private String nombre_empresa;


    public Sucursal() {
    }

    public Sucursal(Integer id_sucursal, String nombre, String telefono, Double latitud, Double longitud, String nombre_encargado, String empresa_rfc, String nombre_empresa) {
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre_encargado = nombre_encargado;
        this.empresa_rfc = empresa_rfc;
        this.nombre_empresa = nombre_empresa;
    }


    public Integer getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(Integer id_sucursal) {
        this.id_sucursal = id_sucursal;
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

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getNombre_encargado() {
        return nombre_encargado;
    }

    public void setNombre_encargado(String nombre_encargado) {
        this.nombre_encargado = nombre_encargado;
    }

    public String getEmpresa_rfc() {
        return empresa_rfc;
    }

    public void setEmpresa_rfc(String empresa_rfc) {
        this.empresa_rfc = empresa_rfc;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }
    
}
