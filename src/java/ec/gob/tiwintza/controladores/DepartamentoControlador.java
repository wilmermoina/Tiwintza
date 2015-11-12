/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.controladores;

import ec.edu.espoch.sga.recursos.Util;
import ec.gob.tiwintza.entidades.DepartamentoEntidad;
import ec.gob.tiwintza.modelos.DepartamentoModelo;
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
public class DepartamentoControlador {

    private DepartamentoEntidad objDepartamento;
    private DepartamentoEntidad objSelDepartamento;
    private ArrayList<DepartamentoEntidad> arrLisDepartamento;
    //<editor-fold defaultstate="collapsed" desc="Sets y Gets">

    /**
     * @return the objDepartamento
     */
    public DepartamentoEntidad getObjDepartamento() {
        return objDepartamento;
    }

    /**
     * @param objDepartamento the objDepartamento to set
     */
    public void setObjDepartamento(DepartamentoEntidad objDepartamento) {
        this.objDepartamento = objDepartamento;
    }

    /**
     * @return the objSelDepartamento
     */
    public DepartamentoEntidad getObjSelDepartamento() {
        return objSelDepartamento;
    }

    /**
     * @param objSelDepartamento the objSelDepartamento to set
     */
    public void setObjSelDepartamento(DepartamentoEntidad objSelDepartamento) {
        this.objSelDepartamento = objSelDepartamento;
    }

    /**
     * @return the arrLisDepartamento
     */
    public ArrayList<DepartamentoEntidad> getArrLisDepartamento() {
        return arrLisDepartamento;
    }

    /**
     * @param arrLisDepartamento the arrLisDepartamento to set
     */
    public void setArrLisDepartamento(ArrayList<DepartamentoEntidad> arrLisDepartamento) {
        this.arrLisDepartamento = arrLisDepartamento;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">

    @PostConstruct
    public void reinit() {
        cargarDepartamento();
    }

    public DepartamentoControlador(DepartamentoEntidad objDepartamento, DepartamentoEntidad objSelDepartamento, ArrayList<DepartamentoEntidad> arrLisDepartamento) {
        this.objDepartamento = objDepartamento;
        this.objSelDepartamento = objSelDepartamento;
        this.arrLisDepartamento = arrLisDepartamento;
    }

    public DepartamentoControlador() {
        objDepartamento = new DepartamentoEntidad();
        objSelDepartamento = new DepartamentoEntidad();
        arrLisDepartamento = new ArrayList<>();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    public void cargarDepartamento() {
        try {
            this.arrLisDepartamento = DepartamentoModelo.obtenerDepartamento();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    public void insertarDepartamento() {
        try {
            if (DepartamentoModelo.insertarDepartamento(objDepartamento)) {
                Util.addSuccessMessage("Se ingreso un nuevo DEPARTAMENTO");
            } else {
                Util.mostrarMensaje("Datos no Insertados");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        delete();
        cargarDepartamento();
    }

    public void eliminarDepartamento() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
            long lonIdDepartamentoEliminar = Long.parseLong(params.get("prmIdDepartamentoEliminar"));
            if (DepartamentoModelo.eliminarDepartamento(lonIdDepartamentoEliminar) > 1) {
                Util.addSuccessMessage("Se ELIMINÓ correctamente el Departamento");
            } else {
                Util.mostrarMensaje("No se pudo eliminar el Departamento");
            }
            cargarDepartamento();
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizarDepartamento() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
            long lonIdDepartamentoEliminar = Long.parseLong(params.get("prmIdDepartamentoActualizar"));
            if (DepartamentoModelo.actualizarDepartamento(new DepartamentoEntidad(lonIdDepartamentoEliminar, objSelDepartamento.getDepartamento_descripcion(), objSelDepartamento.getDepartamento_nombre())) > 1) {
                Util.addSuccessMessage("Se ACTUALIZÓ correctamente el Departamento");
            } else {
                Util.mostrarMensaje("No se pudo actualizar el Departamento");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        delete();
        cargarDepartamento();
    }

    void delete() {
        objDepartamento = null;
        objSelDepartamento = null;
        arrLisDepartamento = null;
    }
    //</editor-fold>

}
