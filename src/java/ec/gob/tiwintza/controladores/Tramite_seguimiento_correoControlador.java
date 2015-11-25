/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.controladores;

import ec.edu.espoch.sga.recursos.Util;
import ec.gob.tiwintza.entidades.Tramite_seguimiento_correoEntidad;
import ec.gob.tiwintza.modelos.TipoModelo;
import ec.gob.tiwintza.modelos.Tramite_seguimiento_correoModelo;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author WMOINA
 */
public class Tramite_seguimiento_correoControlador {
    private Tramite_seguimiento_correoEntidad objTramite_seguimiento_correo;
    private Tramite_seguimiento_correoEntidad objSelTramite_seguimiento_correo;
    private ArrayList<Tramite_seguimiento_correoEntidad> arrLisTramite_seguimiento_correo;
    
    
    //<editor-fold defaultstate="collapsed" desc="Sets y Gets"> 

    public Tramite_seguimiento_correoEntidad getObjTramite_seguimiento_correo() {
        return objTramite_seguimiento_correo;
    }

    public void setObjTramite_seguimiento_correo(Tramite_seguimiento_correoEntidad objTramite_seguimiento_correo) {
        this.objTramite_seguimiento_correo = objTramite_seguimiento_correo;
    }

    public Tramite_seguimiento_correoEntidad getObjSelTramite_seguimiento_correo() {
        return objSelTramite_seguimiento_correo;
    }

    public void setObjSelTramite_seguimiento_correo(Tramite_seguimiento_correoEntidad objSelTramite_seguimiento_correo) {
        this.objSelTramite_seguimiento_correo = objSelTramite_seguimiento_correo;
    }

    public ArrayList<Tramite_seguimiento_correoEntidad> getArrLisTramite_seguimiento_correo() {
        return arrLisTramite_seguimiento_correo;
    }

    public void setArrLisTramite_seguimiento_correo(ArrayList<Tramite_seguimiento_correoEntidad> arrLisTramite_seguimiento_correo) {
        this.arrLisTramite_seguimiento_correo = arrLisTramite_seguimiento_correo;
    }
     //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    @PostConstruct
       public void reint() {
      cargarTramite_seguimiento_correo();
    }

    public Tramite_seguimiento_correoControlador(Tramite_seguimiento_correoEntidad objTramite_seguimiento_correo, Tramite_seguimiento_correoEntidad objSelTramite_seguimiento_correo, ArrayList<Tramite_seguimiento_correoEntidad> arrLisTramite_seguimiento_correo) {
        this.objTramite_seguimiento_correo = objTramite_seguimiento_correo;
        this.objSelTramite_seguimiento_correo = objSelTramite_seguimiento_correo;
        this.arrLisTramite_seguimiento_correo = arrLisTramite_seguimiento_correo;
    }

    public Tramite_seguimiento_correoControlador() {
        objTramite_seguimiento_correo = new Tramite_seguimiento_correoEntidad();
        objSelTramite_seguimiento_correo = new Tramite_seguimiento_correoEntidad();
        arrLisTramite_seguimiento_correo = new ArrayList<>();
        
    }
    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    public void cargarTramite_seguimiento_correo() {
        try {
            this.arrLisTramite_seguimiento_correo = Tramite_seguimiento_correoModelo.obtenerTramite_seguimiento_correo();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }
    
    public static ArrayList <Tramite_seguimiento_correoEntidad>cargarTramite_correos(){
        ArrayList<Tramite_seguimiento_correoEntidad> arrLstTramite_seguimiento_correos=new ArrayList<>();
        try {        
            arrLstTramite_seguimiento_correos = Tramite_seguimiento_correoModelo.obtenerTramite_seguimiento_correo();
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
        return arrLstTramite_seguimiento_correos;
    }
    
   public static void eliminarCorreo(long lonTramite_seguimiento_correoId) {
        try {
           
            long lonIdTramite_seguimiento_correoEliminar = lonTramite_seguimiento_correoId;
            if (Tramite_seguimiento_correoModelo.eliminarTramite_seguimiento_correo(lonIdTramite_seguimiento_correoEliminar) > 1) {
                System.out.println("Se elimino el registro del mensaje");
            } else {
               System.out.println("No se el registro del mensajese ");
            }
           
        } catch (Exception e) {
            System.err.println("e" + e.getMessage());
        }
    }
    
   
    
   //</editor-fold> 
    
}
