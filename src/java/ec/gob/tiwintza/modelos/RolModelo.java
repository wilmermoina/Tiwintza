/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.modelos;

import ec.gob.tiwintza.accesodatos.AccesoDatos;
import ec.gob.tiwintza.accesodatos.ConjuntoResultado;
import ec.gob.tiwintza.accesodatos.Parametro;
import ec.gob.tiwintza.entidades.RolEntidad;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author eborja
 */
public class RolModelo {
    
//    public static Boolean actualizarRol(RolEntidad objRolActualizar) throws Exception {
//        Boolean booResultado = false;
//        String strQuery = "SELECT bd_st.fn_update_subcriterio_hijo(?,?,?,?)";
//        ArrayList<Parametro> arrLisParametros = new ArrayList<>();
//        arrLisParametros.add(new Parametro(1, objSubcriterio.getLonId()));
//        arrLisParametros.add(new Parametro(2, objSubcriterio.getObjCriterio().getLonId()));
//        arrLisParametros.add(new Parametro(3, objSubcriterio.getObjSubcriterioPadre().getObjSubcriterioHijo().getLonId()));
//        arrLisParametros.add(
//                new Parametro(4, objSubcriterio.getObjSubcriterioPadre().getObjSubcriterioHijo().getObjCriterio().getLonId()));
//        ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strQuery, arrLisParametros);
//        while (conResultado.next()) {
//            if (conResultado.getString(0).equals("true")) {
//                booResultado = true;
//            }
//        }
//        return booResultado;
//    }

    public static boolean insertarRol(RolEntidad objRolIngresar) throws Exception {
        boolean booRespuesta = false;
        try {
            ArrayList<Parametro> arrLisParametros = new ArrayList<>();
            String strSql = "select bd_st.fn_insert_rol(?)";
            arrLisParametros.add(new Parametro(1, objRolIngresar.getRol_descripcion()));
            ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strSql, arrLisParametros);
            while (conResultado.next()) {
                if (conResultado.getBoolean(0) == true) {
                    booRespuesta = true;
                }
            }
            conResultado = null;
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
        return booRespuesta;
    }

//    public static ArrayList<CSubcriterioHijo> obtenerSubcriterio() throws Exception {
//        ArrayList<CSubcriterioHijo> arrLstSubcriterio = new ArrayList<>();
//        try {
//            String strSql = "SELECT * FROM sga.fn_select_subcriterio();";
//            ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strSql);
//            arrLstSubcriterio = llenarSubcriterio(conResultado);
//            conResultado = null;
//        } catch (SQLException exConec) {
//            throw new Exception(exConec.getMessage());
//        }
//        return arrLstSubcriterio;
//    }
//
//    public static ArrayList<CSubcriterioHijo> llenarSubcriterio(ConjuntoResultado conResultado) throws Exception {
//        ArrayList<CSubcriterioHijo> arrLstSubcriterio = new ArrayList<>();
//        CSubcriterioHijo objSubcriterio = null;
//        try {
//            while (conResultado.next()) {
//                if (conResultado.getBoolean(7) == true) {
//                    objSubcriterio = new CSubcriterioHijo(conResultado.getLong(0), conResultado.getString(3),
//                            new CSubcriterioPadre(new CSubcriterioHijo(conResultado.getLong(4),conResultado.getString(8), new CCriterio(conResultado.getLong(5)))),
//                            new CCriterio(conResultado.getLong(1), conResultado.getString(2)), conResultado.getBoolean(6), conResultado.getBoolean(7));
//                    arrLstSubcriterio.add(objSubcriterio);
//                }
//            }
//        } catch (Exception e) {
//            arrLstSubcriterio.clear();
//            //  integracion.auditoria.log ublog = new integracion.auditoria.log();
//            // ublog.write("Modulo", "llenarModulos", e.getClass().getName(), e.getMessage());
//            throw e;
//        }
//        return arrLstSubcriterio;
//    }
//
//    public static int eliminarSubcriterioPadreHijos(long lonSubcriterioId, long lonCriterioId) throws Exception {
//        String strQuery = "SELECT sga.fg_update_subcriterio_padre_hijos_eliminacion(?,?)";
//        int intResultado = 0;
//        ArrayList<Parametro> lisParametros = new ArrayList<Parametro>();
//        lisParametros.add(new Parametro(1, lonSubcriterioId));
//        lisParametros.add(new Parametro(2, lonCriterioId));
//        ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strQuery, lisParametros);
//        while (conResultado.next()) {
//            intResultado = (int) conResultado.getLong(0);
//        }
//        return intResultado;
//    }
    
}
