/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.entidades;

/**
 *
 * @author WMOINA
 */
public class Tramite_seguimiento_correoEntidad {

    private long tramite_id;
    private String comentario_tramite_descripcion;
    private String departamento_nombre;
    private String usuario_email;
    
    //<editor-fold defaultstate="collapsed" desc="Sets y Gets"> 
    
    public long getTramite_id() {
        return tramite_id;
    }

    public void setTramite_id(long tramite_id) {
        this.tramite_id = tramite_id;
    }

    public String getComentario_tramite_descripcion() {
        return comentario_tramite_descripcion;
    }

    public void setComentario_tramite_descripcion(String comentario_tramite_descripcion) {
        this.comentario_tramite_descripcion = comentario_tramite_descripcion;
    }

    public String getDepartamento_nombre() {
        return departamento_nombre;
    }

    public void setDepartamento_nombre(String departamento_nombre) {
        this.departamento_nombre = departamento_nombre;
    }

    public String getUsuario_email() {
        return usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

      //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">

    public Tramite_seguimiento_correoEntidad() {
    }
    public Tramite_seguimiento_correoEntidad(long tramite_id, String comentario_tramite_descripcion, String departamento_nombre, String usuario_email) {
        this.tramite_id = tramite_id;
        this.comentario_tramite_descripcion = comentario_tramite_descripcion;
        this.departamento_nombre = departamento_nombre;
        this.usuario_email = usuario_email;
    }

    public Tramite_seguimiento_correoEntidad(long tramite_id) {
        this.tramite_id = tramite_id;
    }
     //</editor-fold>
}
