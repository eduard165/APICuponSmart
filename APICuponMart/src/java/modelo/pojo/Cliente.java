package modelo.pojo;

public class Cliente {

    private Integer idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String correoElectronico;
    private Integer direccionID;
    private String fechaNacimiento;
    private String password;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correoElectronico, Integer direccionID, String fechaNacimiento, String password) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccionID = direccionID;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getDireccionID() {
        return direccionID;
    }

    public void setDireccionID(Integer direccionID) {
        this.direccionID = direccionID;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean todosAtributosLlenos() {
        return siEsUncorreoValido() && this.password.isEmpty();
    }

    public Boolean siEsUncorreoValido() {
        return this.correoElectronico.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$");
    }
}
