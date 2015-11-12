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
public class DepartamentoEntidad {
    private long departamento_id;
    private String departamento_descripcion;
    private String departamento_nombre;
    //<editor-fold defaultstate="collapsed" desc="Sets y Gets">
    /**
     * @return the departamento_id
     */
    public long getDepartamento_id() {
        return departamento_id;
    }

    /**
     * @param departamento_id the departamento_id to set
     */
    public void setDepartamento_id(long departamento_id) {
        this.departamento_id = departamento_id;
    }

    /**
     * @return the departamento_descripcion
     */
    public String getDepartamento_descripcion() {
        return departamento_descripcion;
    }

    /**
     * @param departamento_descripcion the departamento_descripcion to set
     */
    public void setDepartamento_descripcion(String departamento_descripcion) {
        this.departamento_descripcion = departamento_descripcion;
    }

    /**
     * @return the departamento_nombre
     */
    public String getDepartamento_nombre() {
        return departamento_nombre;
    }

    /**
     * @param departamento_nombre the departamento_nombre to set
     */
    public void setDepartamento_nombre(String departamento_nombre) {
        this.departamento_nombre = departamento_nombre;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">

    public DepartamentoEntidad() {
    }

    public DepartamentoEntidad(String departamento_descripcion, String departamento_nombre) {
        this.departamento_descripcion = departamento_descripcion;
        this.departamento_nombre = departamento_nombre;
    }

    public DepartamentoEntidad(long departamento_id, String departamento_descripcion, String departamento_nombre) {
        this.departamento_id = departamento_id;
        this.departamento_descripcion = departamento_descripcion;
        this.departamento_nombre = departamento_nombre;
    }
    //</editor-fold> 
}
