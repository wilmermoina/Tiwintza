/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.controladores;

import ec.edu.espoch.sga.recursos.Util;
import ec.gob.tiwintza.entidades.RolEntidad;
import ec.gob.tiwintza.modelos.RolModelo;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author eborja
 */
@ManagedBean
@RequestScoped
public class RolControlador {

    private RolEntidad objRol;
    private RolEntidad objSelRol;
    private ArrayList<RolEntidad> arrLisRol;
    //<editor-fold defaultstate="collapsed" desc="Sets y Gets">

    /**
     * @return the objRol
     */
    public RolEntidad getObjRol() {
        return objRol;
    }

    /**
     * @param objRol the objRol to set
     */
    public void setObjRol(RolEntidad objRol) {
        this.objRol = objRol;
    }

    /**
     * @return the objSelRol
     */
    public RolEntidad getObjSelRol() {
        return objSelRol;
    }

    /**
     * @param objSelRol the objSelRol to set
     */
    public void setObjSelRol(RolEntidad objSelRol) {
        this.objSelRol = objSelRol;
    }

    /**
     * @return the arrLisRol
     */
    public ArrayList<RolEntidad> getArrLisRol() {
        return arrLisRol;
    }

    /**
     * @param arrLisRol the arrLisRol to set
     */
    public void setArrLisRol(ArrayList<RolEntidad> arrLisRol) {
        this.arrLisRol = arrLisRol;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">

    @PostConstruct
    public void reinit() {
        cargarRol();
    }

    public RolControlador(RolEntidad objRol, RolEntidad objSelRol, ArrayList<RolEntidad> arrLisRol) {
        this.objRol = objRol;
        this.objSelRol = objSelRol;
        this.arrLisRol = arrLisRol;
    }

    /**
     * Creates a new instance of RolControlador
     */
    public RolControlador() {
        objRol = new RolEntidad();
        objSelRol = new RolEntidad();
        arrLisRol = new ArrayList<>();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">

    public void cargarRol() {
        try {
            this.arrLisRol = RolModelo.obtenerRol();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    public void insertarRol() {
        try {
            if (RolModelo.insertarRol(objRol)) {
                Util.addSuccessMessage("Se ingreso un nuevo ROL");
            } else {
                Util.mostrarMensaje("Datos no Insertados");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        delete();
    }
    
    void delete(){
        objRol=null;
        objSelRol=null;
        arrLisRol=null;
    }
    //</editor-fold>
}
