/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.controladores;

import ec.edu.espoch.sga.recursos.Util;
import ec.gob.tiwintza.entidades.UsuarioEntidad;
import ec.gob.tiwintza.modelos.UsuarioModelo;
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
public class UsuarioControlador {

    private UsuarioEntidad objUsuario;
    private UsuarioEntidad objSelUsuario;
    private ArrayList<UsuarioEntidad> arrLisUsuario;

    //<editor-fold defaultstate="collapsed" desc="Sets y Gets">
    /**
     * @return the objUsuario
     */
    public UsuarioEntidad getObjUsuario() {
        return objUsuario;
    }

    /**
     * @param objUsuario the objUsuario to set
     */
    public void setObjUsuario(UsuarioEntidad objUsuario) {
        this.objUsuario = objUsuario;
    }

    /**
     * @return the objSelUsuario
     */
    public UsuarioEntidad getObjSelUsuario() {
        return objSelUsuario;
    }

    /**
     * @param objSelUsuario the objSelUsuario to set
     */
    public void setObjSelUsuario(UsuarioEntidad objSelUsuario) {
        this.objSelUsuario = objSelUsuario;
    }

    /**
     * @return the arrLisUsuario
     */
    public ArrayList<UsuarioEntidad> getArrLisUsuario() {
        return arrLisUsuario;
    }

    /**
     * @param arrLisUsuario the arrLisUsuario to set
     */
    public void setArrLisUsuario(ArrayList<UsuarioEntidad> arrLisUsuario) {
        this.arrLisUsuario = arrLisUsuario;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">

    @PostConstruct
    public void reinit() {
        cargarUsuario();
    }

    public UsuarioControlador(UsuarioEntidad objUsuario, UsuarioEntidad objSelUsuario, ArrayList<UsuarioEntidad> arrLisUsuario) {
        this.objUsuario = objUsuario;
        this.objSelUsuario = objSelUsuario;
        this.arrLisUsuario = arrLisUsuario;
    }

    public UsuarioControlador() {
        objUsuario = new UsuarioEntidad();
        objSelUsuario = new UsuarioEntidad();
        arrLisUsuario = new ArrayList<>();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    public void cargarUsuario() {
        try {
            this.arrLisUsuario = UsuarioModelo.obtenerUsuario();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }

    public void insertarUsuario() {
        try {
            if (UsuarioModelo.insertarUsuario(objUsuario)) {
                Util.addSuccessMessage("Se ingreso un nuevo USUARIO");
            } else {
                Util.mostrarMensaje("Datos no Insertados");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        delete();
        cargarUsuario();
    }

    public void eliminarUsuario() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
            long lonIdUsuarioEliminar = Long.parseLong(params.get("prmIdUsuarioEliminar"));
            if (UsuarioModelo.eliminarUsuario(lonIdUsuarioEliminar) > 1) {
                Util.addSuccessMessage("Se ELIMINÓ correctamente el Usuario");
            } else {
                Util.mostrarMensaje("No se pudo eliminar el Usuario");
            }
            cargarUsuario();
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
    }

    public void actualizarUsuario() {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
            long lonIdUsuarioEliminar = Long.parseLong(params.get("prmIdUsuarioActualizar"));
            if (UsuarioModelo.actualizarUsuario(new UsuarioEntidad(lonIdUsuarioEliminar, objSelUsuario.getUsuario_cedula(), objSelUsuario.getUsuario_nombre(), objSelUsuario.getUsuario_apellido(), objSelUsuario.getUsuario_cuenta(), objSelUsuario.getUsuario_password(), objSelUsuario.getUsuario_email())) > 1) {
                Util.addSuccessMessage("Se ACTUALIZÓ correctamente el Usuario");
            } else {
                Util.mostrarMensaje("No se pudo actualizar el Usuario");
            }
        } catch (Exception e) {
            Util.addErrorMessage(e.getMessage());
        }
        delete();
        cargarUsuario();
    }

    void delete() {
        objUsuario = null;
        objSelUsuario = null;
        arrLisUsuario = null;
    }
    //</editor-fold>

}
