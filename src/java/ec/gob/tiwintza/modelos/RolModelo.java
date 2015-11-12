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
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author eborja
 */
public class RolModelo {

    public static int actualizarRol(RolEntidad objRolActualizar) throws Exception {
        int intResultado = 0;
        String strQuery = "select bd_st.fn_update_rol(?,?)";
        ArrayList<Parametro> arrLisParametros = new ArrayList<>();
        arrLisParametros.add(new Parametro(1, objRolActualizar.getRol_id()));
        arrLisParametros.add(new Parametro(2, objRolActualizar.getRol_descripcion()));
        ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strQuery, arrLisParametros);
        while (conResultado.next()) {
            intResultado = conResultado.getInt(0);
        }
        return intResultado;
    }

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

    public static ArrayList<RolEntidad> obtenerRol() throws Exception {
        ArrayList<RolEntidad> arrLstSubcriterio = new ArrayList<>();
        try {
            String strSql = "call bd_st.pr_select_rol();";
            ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strSql);
            arrLstSubcriterio = llenarRol(conResultado);
            conResultado = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return arrLstSubcriterio;
    }

    public static ArrayList<RolEntidad> llenarRol(ConjuntoResultado conResultado) throws Exception {
        ArrayList<RolEntidad> arrLstSubcriterio = new ArrayList<>();
        RolEntidad objRol;
        try {
            while (conResultado.next()) {
                    objRol = new RolEntidad(Long.parseLong(conResultado.getBigInteger(0).toString()), conResultado.getString(1));
                    arrLstSubcriterio.add(objRol);
            }
        } catch (Exception e) {
            arrLstSubcriterio.clear();
            //  integracion.auditoria.log ublog = new integracion.auditoria.log();
            // ublog.write("Modulo", "llenarModulos", e.getClass().getName(), e.getMessage());
            throw e;
        }
        return arrLstSubcriterio;
    }

    public static int eliminarRol(long lonIdRolEliminar) throws Exception {
        String strQuery = "select bd_st.fn_delete_rol(?)";
        int intResultado = 0;
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, lonIdRolEliminar));
        ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strQuery, lisParametros);
        while (conResultado.next()) {
            intResultado = conResultado.getInt(0);
        }
        return intResultado;
    }

}
