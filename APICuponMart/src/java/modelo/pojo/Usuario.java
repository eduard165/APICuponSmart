package modelo.pojo;

public class Usuario {

    private Integer id_usuario;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String curp;
    private String correo_electronico;
    private String username;
    private String password;
    private Integer id_rol;
    private String empresa_rfc;
    private String nombre_rol;

    public Usuario() {
    }

    public Usuario(Integer id_usuario, String nombre, String apellido_paterno, String apellido_materno, String curp, String correo_electronico, String username, String password, Integer id_rol, String empresa_rfc) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.curp = curp;
        this.correo_electronico = correo_electronico;
        this.username = username;
        this.password = password;
        this.id_rol = id_rol;
        this.empresa_rfc = empresa_rfc;
        switch (id_rol) {
            case 1:
                this.nombre_rol = "Administrador general";
                break;
            case 2:
                this.nombre_rol = "Administrador comercial";
                break;
            default:
                this.nombre_rol = "Rol Desconocido";
                break;
        }

    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getEmpresa_rfc() {
        return empresa_rfc;
    }

    public void setEmpresa_rfc(String empresa_rfc) {
        this.empresa_rfc = empresa_rfc;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String toString(Integer nombre_rol) {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", curp=" + curp + ", correo_electronico=" + correo_electronico + ", username=" + username + ", password=" + password + ", id_rol=" + id_rol + ", empresa_rfc=" + empresa_rfc + '}';
    }
}
