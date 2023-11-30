package modelo.pojo;

public class Direccion {

    private Integer idDireccion;
    private String calle;
    private Integer numero;
    private String codigoPostal;
    private String colonia;
    private Integer idMunicipio;
    private Integer idCliente;
    private Integer idSucursal;
    private String empresaRFC;

    public Direccion() {
    }

    public Direccion(Integer idDireccion, String calle, Integer numero, String codigoPostal, String colonia, Integer idMunicipio, Integer idCliente, Integer idSucursal, String empresaRFC) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
        this.idMunicipio = idMunicipio;
        this.idCliente = idCliente;
        this.idSucursal = idSucursal;
        this.empresaRFC = empresaRFC;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getEmpresaRFC() {
        return empresaRFC;
    }

    public void setEmpresaRFC(String empresaRFC) {
        this.empresaRFC = empresaRFC;
    }
    

   
}
