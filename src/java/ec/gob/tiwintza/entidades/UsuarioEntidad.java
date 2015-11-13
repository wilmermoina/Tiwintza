/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.entidades;

/**
 *
 * @author eborja
 */
public class UsuarioEntidad {

    private long usuario_id;
    private String usuario_cedula;
    private String usuario_nombre;
    private String usuario_apellido;
    private String usuario_cuenta;
    private String usuario_password;
    private String usuario_email;

    //<editor-fold defaultstate="collapsed" desc="Sets y Gets">
    /**
     * @return the usuario_id
     */
    public long getUsuario_id() {
        return usuario_id;
    }

    /**
     * @param usuario_id the usuario_id to set
     */
    public void setUsuario_id(long usuario_id) {
        this.usuario_id = usuario_id;
    }

    /**
     * @return the usuario_cedula
     */
    public String getUsuario_cedula() {
        return usuario_cedula;
    }

    /**
     * @param usuario_cedula the usuario_cedula to set
     */
    public void setUsuario_cedula(String usuario_cedula) {
        this.usuario_cedula = usuario_cedula;
    }

    /**
     * @return the usuario_nombre
     */
    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    /**
     * @param usuario_nombre the usuario_nombre to set
     */
    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    /**
     * @return the usuario_apellido
     */
    public String getUsuario_apellido() {
        return usuario_apellido;
    }

    /**
     * @param usuario_apellido the usuario_apellido to set
     */
    public void setUsuario_apellido(String usuario_apellido) {
        this.usuario_apellido = usuario_apellido;
    }

    /**
     * @return the usuario_cuenta
     */
    public String getUsuario_cuenta() {
        return usuario_cuenta;
    }

    /**
     * @param usuario_cuenta the usuario_cuenta to set
     */
    public void setUsuario_cuenta(String usuario_cuenta) {
        this.usuario_cuenta = usuario_cuenta;
    }

    /**
     * @return the usuario_password
     */
    public String getUsuario_password() {
        return usuario_password;
    }

    /**
     * @param usuario_password the usuario_password to set
     */
    public void setUsuario_password(String usuario_password) {
        this.usuario_password = usuario_password;
    }

    /**
     * @return the usuario_email
     */
    public String getUsuario_email() {
        return usuario_email;
    }

    /**
     * @param usuario_email the usuario_email to set
     */
    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">

    public UsuarioEntidad() {
    }

    public UsuarioEntidad(long usuario_id, String usuario_cedula, String usuario_nombre, String usuario_apellido, String usuario_cuenta, String usuario_password, String usuario_email) {
        this.usuario_id = usuario_id;
        this.usuario_cedula = usuario_cedula;
        this.usuario_nombre = usuario_nombre;
        this.usuario_apellido = usuario_apellido;
        this.usuario_cuenta = usuario_cuenta;
        this.usuario_password = usuario_password;
        this.usuario_email = usuario_email;
    }

    public UsuarioEntidad(String usuario_cedula, String usuario_nombre, String usuario_apellido, String usuario_cuenta, String usuario_email) {
        this.usuario_cedula = usuario_cedula;
        this.usuario_nombre = usuario_nombre;
        this.usuario_apellido = usuario_apellido;
        this.usuario_cuenta = usuario_cuenta;
        this.usuario_email = usuario_email;
    }
    //</editor-fold>

}
