/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.modelos;

import ec.gob.tiwintza.accesodatos.AccesoDatos;
import ec.gob.tiwintza.accesodatos.ConjuntoResultado;
import ec.gob.tiwintza.accesodatos.Parametro;
import ec.gob.tiwintza.entidades.DepartamentoEntidad;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author eborja
 */
public class DepartamentoModelo {

    public static int actualizarDepartamento(DepartamentoEntidad objDepartamentoActualizar) throws Exception {
        int intResultado = 0;
        String strQuery = "select bd_st.fn_update_departamento(?,?,?)";
        ArrayList<Parametro> arrLisParametros = new ArrayList<>();
        arrLisParametros.add(new Parametro(1, objDepartamentoActualizar.getDepartamento_id()));
        arrLisParametros.add(new Parametro(2, objDepartamentoActualizar.getDepartamento_descripcion()));
        arrLisParametros.add(new Parametro(3, objDepartamentoActualizar.getDepartamento_nombre()));
        ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strQuery, arrLisParametros);
        while (conResultado.next()) {
            intResultado = conResultado.getInt(0);
        }
        return intResultado;
    }

    public static boolean insertarDepartamento(DepartamentoEntidad objDepartamentoIngresar) throws Exception {
        boolean booRespuesta = false;
        try {
            ArrayList<Parametro> arrLisParametros = new ArrayList<>();
            String strSql = "select bd_st.fn_insert_departamento(?,?)";
            arrLisParametros.add(new Parametro(1, objDepartamentoIngresar.getDepartamento_descripcion()));
            arrLisParametros.add(new Parametro(2, objDepartamentoIngresar.getDepartamento_nombre()));
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

    public static ArrayList<DepartamentoEntidad> obtenerDepartamento() throws Exception {
        ArrayList<DepartamentoEntidad> arrLstSubcriterio = new ArrayList<>();
        try {
            String strSql = "call bd_st.pr_select_departamento();";
            ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strSql);
            arrLstSubcriterio = llenarDepartamento(conResultado);
            conResultado = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return arrLstSubcriterio;
    }

    public static ArrayList<DepartamentoEntidad> llenarDepartamento(ConjuntoResultado conResultado) throws Exception {
        ArrayList<DepartamentoEntidad> arrLstSubcriterio = new ArrayList<>();
        DepartamentoEntidad objDepartamento;
        try {
            while (conResultado.next()) {
                objDepartamento = new DepartamentoEntidad(Long.parseLong(conResultado.getBigInteger(0).toString()), conResultado.getString(1), conResultado.getString(2));
                arrLstSubcriterio.add(objDepartamento);
            }
        } catch (Exception e) {
            arrLstSubcriterio.clear();
            //  integracion.auditoria.log ublog = new integracion.auditoria.log();
            // ublog.write("Modulo", "llenarModulos", e.getClass().getName(), e.getMessage());
            throw e;
        }
        return arrLstSubcriterio;
    }

    public static int eliminarDepartamento(long lonIdDepartamentoEliminar) throws Exception {
        String strQuery = "select bd_st.fn_delete_departamento(?)";
        int intResultado = 0;
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, lonIdDepartamentoEliminar));
        ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strQuery, lisParametros);
        while (conResultado.next()) {
            intResultado = conResultado.getInt(0);
        }
        return intResultado;
    }
}
