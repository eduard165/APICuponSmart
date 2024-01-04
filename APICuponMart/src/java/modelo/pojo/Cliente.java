package modelo.pojo;

public class Cliente {

    private Integer id_cliente;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String telefono;
    private String correo_electronico;
    private String fecha_nacimiento;
    private String calle;
    private Integer numero_calle;
    private String password;

    public Cliente() {
    }

    public Cliente(Integer id_cliente, String nombre, String apellido_paterno, String apellido_materno, String telefono, String correo_electronico, String fecha_nacimiento, String calle, Integer numero_calle,String password) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.fecha_nacimiento = fecha_nacimiento;
        this.calle = calle;
        this.numero_calle = numero_calle;
        this.password = password;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero_calle() {
        return numero_calle;
    }

    public void setNumero_calle(Integer numero_calle) {
        this.numero_calle = numero_calle;
    }
    
    
    
}
