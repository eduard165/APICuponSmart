
package modelo.pojo;

public class Empresa {

    private String rfc;
    private String nombre;
    private String nombre_comercial;
    private String representante_legal;
    private String email;
    private String telefono;
    private String paginaWeb;
    private String id_estatus;
    private byte[] logo;
    private String logoBase64;

    public Empresa() {
    }

    public Empresa(String rfc, String nombre, String nombre_comercial, String representante_legal, String email, String telefono, String paginaWeb, String id_estatus, byte[] logo, String logoBase64) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.nombre_comercial = nombre_comercial;
        this.representante_legal = representante_legal;
        this.email = email;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.id_estatus = id_estatus;
        this.logo = logo;
        this.logoBase64 = logoBase64;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getRepresentante_legal() {
        return representante_legal;
    }

    public void setRepresentante_legal(String representante_legal) {
        this.representante_legal = representante_legal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getId_estatus() {
        return id_estatus;
    }

    public void setId_estatus(String id_estatus) {
        this.id_estatus = id_estatus;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLogoBase64() {
        return logoBase64;
    }

    public void setLogoBase64(String logoBase64) {
        this.logoBase64 = logoBase64;
    }
    
}
