/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.modelos;

import ec.gob.tiwintza.accesodatos.AccesoDatos;
import ec.gob.tiwintza.accesodatos.ConjuntoResultado;
import ec.gob.tiwintza.accesodatos.Parametro;
import ec.gob.tiwintza.entidades.TipoEntidad;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wmoina
 */
public class TipoModelo {
    public static boolean insertarTipo(TipoEntidad objTipoIngresar) throws Exception{
        boolean boolRespuesta = false;
        try {
            ArrayList<Parametro> arrayListParametros = new ArrayList<>();
            String strSql = "select bd_st.fn_insert_tipo(?,?)";
            arrayListParametros.add(new Parametro(1,objTipoIngresar.getTipo_nombre()));
            arrayListParametros.add(new Parametro(2,objTipoIngresar.getTipo_descripcion()));
            ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strSql,arrayListParametros);
            while (conResultado.next()){
                if (conResultado.getBoolean(0)==true) {
                    boolRespuesta=true;
                }
            }
            conResultado =null;
        } catch (SQLException e) {
            System.err.println("error" + e.getMessage());
        }
        return boolRespuesta;
    }
    
    public static boolean actualizarTipo(TipoEntidad objTipoActualizar) throws Exception{
    
        boolean booRespuesta= false;
        String strQuery = "select bd_st.fn_update_tipo(?,?,?)";
        ArrayList<Parametro> listParametros = new ArrayList<>();
        listParametros.add(new Parametro(1,objTipoActualizar.getTipo_id()));
        listParametros.add(new Parametro(2,objTipoActualizar.getTipo_nombre()));
        listParametros.add(new Parametro(3,objTipoActualizar.getTipo_descripcion()));
        ConjuntoResultado conResultado= AccesoDatos.ejecutaQuery(strQuery,listParametros);
        while(conResultado.next()){
            if(conResultado.getString(0).equals("true")){
                booRespuesta=true;
            }
        }
        return booRespuesta;
    }
    
    public static ArrayList<TipoEntidad> obtenerTipo() throws Exception{
        ArrayList<TipoEntidad> arrLstTipo =new ArrayList<>();
        try {
            String strSql = "call bd_st.pr_select_tipo(); ";
            ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strSql);
            arrLstTipo= llenarTipo(conResultado);
            conResultado=null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return arrLstTipo;
    }
    
    public static ArrayList<TipoEntidad> llenarTipo(ConjuntoResultado conResultado) throws Exception {
        ArrayList<TipoEntidad> arrLstTipo = new ArrayList<>();
        TipoEntidad objTipo = null;
        try {
            while (conResultado.next()) {
                objTipo= new TipoEntidad(conResultado.getLong(0),conResultado.getString(1),conResultado.getString(2));
                arrLstTipo.add(objTipo);
            }
        } catch (Exception e) {
            arrLstTipo.clear();
               throw e;
        }
        return arrLstTipo;
    }
    
  public static int eliminarTipo(long lonTipoId) throws Exception {
        String strQuery = "select bd_st.fn_delete_tipo(?)";
        int intResultado = 0;
        ArrayList<Parametro> lisParametros = new ArrayList<Parametro>();
        lisParametros.add(new Parametro(1, lonTipoId));
        ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strQuery, lisParametros);
        while (conResultado.next()) {
            intResultado = (int) conResultado.getLong(0);
        }
        return intResultado;
    }
}
