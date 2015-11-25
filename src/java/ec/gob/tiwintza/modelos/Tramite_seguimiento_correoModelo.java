/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.modelos;

import ec.gob.tiwintza.accesodatos.AccesoDatos;
import ec.gob.tiwintza.accesodatos.ConjuntoResultado;
import ec.gob.tiwintza.accesodatos.Parametro;
import ec.gob.tiwintza.entidades.Tramite_seguimiento_correoEntidad;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author WMOINA
 */
public class Tramite_seguimiento_correoModelo {
    
    
    
     public static ArrayList<Tramite_seguimiento_correoEntidad> obtenerTramite_seguimiento_correo() throws Exception{
        ArrayList<Tramite_seguimiento_correoEntidad> arrLstTramite_seguimiento_correo=new ArrayList<>();
        try {
            String strSql = "call bd_st.pr_select_tramite_seguimiento_correo(); ";
            ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strSql);
            arrLstTramite_seguimiento_correo= llenarTramite_seguimiento_correo(conResultado);
            conResultado=null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return arrLstTramite_seguimiento_correo;
    }
    
     
    public static ArrayList<Tramite_seguimiento_correoEntidad> llenarTramite_seguimiento_correo(ConjuntoResultado conResultado) throws Exception {
        ArrayList<Tramite_seguimiento_correoEntidad> arrLstTramite_seguimiento_correo = new ArrayList<>();
        Tramite_seguimiento_correoEntidad objTramite_seguimiento_correo;
        try {
            while (conResultado.next()) {
                objTramite_seguimiento_correo = new Tramite_seguimiento_correoEntidad(Long.parseLong(conResultado.getBigInteger(0).toString()),conResultado.getString(1),conResultado.getString(2),conResultado.getString(3));
                arrLstTramite_seguimiento_correo.add(objTramite_seguimiento_correo);
            }
        } catch (Exception e) {
            arrLstTramite_seguimiento_correo.clear();
               throw e;
        }
        return arrLstTramite_seguimiento_correo;
    }
    
    public static int eliminarTramite_seguimiento_correo(long lonTramite_seguimiento_correoId) throws Exception {
        String strQuery = "select bd_st.fn_delete_tramite_seguimiento_correo(?)";
        int intResultado = 0;
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, lonTramite_seguimiento_correoId));
        ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strQuery, lisParametros);
        while (conResultado.next()) {
            intResultado = conResultado.getInt(0);
        }
        return intResultado;
    }
}
