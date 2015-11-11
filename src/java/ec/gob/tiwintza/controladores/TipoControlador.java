/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.controladores;

import ec.edu.espoch.sga.recursos.Util;
import ec.gob.tiwintza.entidades.TipoEntidad;
import ec.gob.tiwintza.modelos.TipoModelo;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Wmoina
 */
@ManagedBean
@RequestScoped
public class TipoControlador {
   
    private TipoEntidad objTipo;
    private TipoEntidad objSelRol;
    private ArrayList<TipoEntidad> arrLisTipo;

    //<editor-fold defaultstate="collapsed" desc="Sets y Gets"> 
    public TipoEntidad getObjTipo() {
        return objTipo;
    }

    public void setObjTipo(TipoEntidad objTipo) {
        this.objTipo = objTipo;
    }

    public TipoEntidad getObjSelRol() {
        return objSelRol;
    }

    public void setObjSelRol(TipoEntidad objSelRol) {
        this.objSelRol = objSelRol;
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
   
   public void reint(){
       cargarTipo();
   }
   
     public TipoControlador(TipoEntidad objTipo, TipoEntidad objSelRol, ArrayList<TipoEntidad> arrLisTipo) {
        this.objTipo = objTipo;
        this.objSelRol = objSelRol;
        this.arrLisTipo = arrLisTipo;
    }
     
     public TipoControlador(){
         objTipo = new TipoEntidad();
         objSelRol= new TipoEntidad();
         arrLisTipo= new ArrayList<>();
     }
    
   //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">

  public void cargarTipo(){
      try {
          this.arrLisTipo=TipoModelo.obtenerTipo();
      } catch (Exception e) {
          System.err.println("e"+e.getMessage());
      }
  }
  
  public void insertarTipo(){
      try {
          if(TipoModelo.insertarTipo(objTipo)){
              Util.addSuccessMessage("Se ingreso un nuevo Tipo de Trámite");
          } else{
              Util.mostrarMensaje("Datos no ingresados");
          }
      } catch (Exception e) {
          Util.addErrorMessage(e.getMessage());
      }
      delete();
  }
  
  void delete(){
      objTipo=null;
      objSelRol=null;
      arrLisTipo=null;
  }
//</editor-fold>
}
