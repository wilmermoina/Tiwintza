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
public class RolEntidad {
    private long rol_id;
    private String rol_descripcion;
    //<editor-fold defaultstate="collapsed" desc="Sets y Gets">
    /**
     * @return the rol_id
     */
    public long getRol_id() {
        return rol_id;
    }

    /**
     * @param rol_id the rol_id to set
     */
    public void setRol_id(long rol_id) {
        this.rol_id = rol_id;
    }

    /**
     * @return the rol_descripcion
     */
    public String getRol_descripcion() {
        return rol_descripcion;
    }

    /**
     * @param rol_descripcion the rol_descripcion to set
     */
    public void setRol_descripcion(String rol_descripcion) {
        this.rol_descripcion = rol_descripcion;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">

    public RolEntidad(String rol_descripcion) {
        this.rol_descripcion = rol_descripcion;
    }

    public RolEntidad() {
    }

    public RolEntidad(long rol_id, String rol_descripcion) {
        this.rol_id = rol_id;
        this.rol_descripcion = rol_descripcion;
    }
    //</editor-fold>
}
