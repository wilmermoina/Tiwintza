/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.controladores;

import ec.edu.espoch.sga.recursos.Util;
import ec.gob.tiwintza.entidades.TipoEntidad;
import ec.gob.tiwintza.entidades.Tramite_seguimiento_correoEntidad;
import ec.gob.tiwintza.modelos.TipoModelo;
import ec.gob.tiwintza.modelos.TipoModelo;
import ec.gob.tiwintza.modelos.Tramite_seguimiento_correoModelo;
import ec.gob.tiwintza.recursos.Enviar_correo;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Wmoina
 */
@ManagedBean
@RequestScoped
public class TipoControlador {

    private TipoEntidad objTipo;
    private TipoEntidad objSelTipo;
    private ArrayList<TipoEntidad> arrLisTipo;
    
    //<editor-fold defaultstate="collapsed" desc="Sets y Gets"> 
    public TipoEntidad getObjTipo() {
        return objTipo;
    }

    public void setObjTipo(TipoEntidad objTipo) {
        this.objTipo = objTipo;
    }

    public TipoEntidad getObjSelTipo() {
        return objSelTipo;
    }

    public void setObjSelTipo(TipoEntidad objSelTipo) {
        this.objSelTipo = objSelTipo;
    }

    public ArrayList<TipoEntidad> getArrLisTipo() {
        return arrLisTipo;
    }

    public void setArrLisTipo(ArrayList<TipoEntidad> arrLisTipo) {
        this.arrLisTipo = arrLisTipo;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    
    @PostConstruct

    public void reint() {
        cargarTipo();
    }

    public TipoControlador(TipoEntidad objTipo, TipoEntidad objSelTipo, ArrayList<TipoEntidad> arrLisTipo) {
        this.objTipo = objTipo;
        this.objSelTipo = objSelTipo;
        this.arrLisTipo = arrLisTipo;
    }

    public TipoControlador() {
        objTipo = new TipoEntidad();
        objSelTipo = new TipoEntidad();
        arrLisTipo = new ArrayList<>();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    public void cargarTipo() {
        try {
            this.arrLisTipo = TipoModelo.obtenerTipo();     
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    public void insertarTipo() {
        try {
            if (TipoModelo.insertarTipo(objTipo)) {
                Util.addSuccessMessage("Se ingreso un nuevo Tipo de Trámite");
            } else {
                Util.mostrarMensaje("Datos no ingresados");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        delete();
    }

    void delete() {
        objTipo = null;
        objSelTipo = null;
        arrLisTipo = null;
    }

    public void eliminarTipo() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
            long lonIdTipoEliminar = Long.parseLong(params.get("prmIdTipoEliminar"));
            if (TipoModelo.eliminarTipo(lonIdTipoEliminar) > 1) {
                Util.addSuccessMessage("Se elimino correctamente el tipo de trámite");
            } else {
                Util.mostrarMensaje("No se pudo eliminar el tipo de trámite");
            }
            cargarTipo();
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizarTipo() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
            long lonIdTipoEliminar = Long.parseLong(params.get("prmIdTipoActualizar"));
            if (TipoModelo.actualizarTipo(new TipoEntidad(lonIdTipoEliminar, objSelTipo.getTipo_nombre(), objSelTipo.getTipo_descripcion())) > 1) {
                Util.mostrarMensaje("No se actualizó el tipo de trámite");
            } else {
                Util.addSuccessMessage("Se actualizó el tramite correctamente");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        delete();
        cargarTipo();
    }
//</editor-fold>
}
