/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.entidades;

/**
 *
 * @author Wmoina
 */
public class TipoEntidad {

    private long tipo_id;
    private String tipo_nombre;
    private String tipo_descripcion;
    //<editor-fold defaultstate="collapsed" desc="Sets y Gets">  
    public long getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(long tipo_id) {
        this.tipo_id = tipo_id;
    }

    public String getTipo_nombre() {
        return tipo_nombre;
    }

    public void setTipo_nombre(String tipo_nombre) {
        this.tipo_nombre = tipo_nombre;
    }

    public String getTipo_descripcion() {
        return tipo_descripcion;
    }

    public void setTipo_descripcion(String tipo_descripcion) {
        this.tipo_descripcion = tipo_descripcion;
    }
       //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">

    public TipoEntidad() {
    }

     public TipoEntidad(long tipo_id, String tipo_nombre, String tipo_descripcion) {
        this.tipo_id = tipo_id;
        this.tipo_nombre = tipo_nombre;
        this.tipo_descripcion = tipo_descripcion;
    }
     public TipoEntidad(long tipo_id) {
        this.tipo_id = tipo_id;
    }
  //</editor-fold>  

   

  
}
