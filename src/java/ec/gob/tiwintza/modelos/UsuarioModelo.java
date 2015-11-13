/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.modelos;

import ec.gob.tiwintza.accesodatos.AccesoDatos;
import ec.gob.tiwintza.accesodatos.ConjuntoResultado;
import ec.gob.tiwintza.accesodatos.Parametro;
import ec.gob.tiwintza.entidades.UsuarioEntidad;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author eborja
 */
public class UsuarioModelo {

    public static int actualizarUsuario(UsuarioEntidad objUsuarioActualizar) throws Exception {
        int intResultado = 0;
        String strQuery = "select bd_st.fn_update_usuario(?,?,?,?,?,?,?)";
        ArrayList<Parametro> arrLisParametros = new ArrayList<>();
        arrLisParametros.add(new Parametro(1, objUsuarioActualizar.getUsuario_id()));
        arrLisParametros.add(new Parametro(2, objUsuarioActualizar.getUsuario_cedula()));
        arrLisParametros.add(new Parametro(3, objUsuarioActualizar.getUsuario_nombre()));
        arrLisParametros.add(new Parametro(4, objUsuarioActualizar.getUsuario_apellido()));
        arrLisParametros.add(new Parametro(5, objUsuarioActualizar.getUsuario_cuenta()));
        arrLisParametros.add(new Parametro(6, objUsuarioActualizar.getUsuario_password()));
        arrLisParametros.add(new Parametro(7, objUsuarioActualizar.getUsuario_email()));
        ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strQuery, arrLisParametros);
        while (conResultado.next()) {
            intResultado = conResultado.getInt(0);
        }
        return intResultado;
    }

    public static boolean insertarUsuario(UsuarioEntidad objUsuarioIngresar) throws Exception {
        boolean booRespuesta = false;
        try {
            ArrayList<Parametro> arrLisParametros = new ArrayList<>();
            String strSql = "select bd_st.fn_insert_usuario(?,?,?,?,?,?)";
            arrLisParametros.add(new Parametro(1, objUsuarioIngresar.getUsuario_cedula()));
            arrLisParametros.add(new Parametro(2, objUsuarioIngresar.getUsuario_nombre()));
            arrLisParametros.add(new Parametro(3, objUsuarioIngresar.getUsuario_apellido()));
            arrLisParametros.add(new Parametro(4, objUsuarioIngresar.getUsuario_cuenta()));
            arrLisParametros.add(new Parametro(5, objUsuarioIngresar.getUsuario_password()));
            arrLisParametros.add(new Parametro(6, objUsuarioIngresar.getUsuario_email()));
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

    public static ArrayList<UsuarioEntidad> obtenerUsuario() throws Exception {
        ArrayList<UsuarioEntidad> arrLstSubcriterio = new ArrayList<>();
        try {
            String strSql = "call bd_st.pr_select_usuario();";
            ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strSql);
            arrLstSubcriterio = llenarUsuario(conResultado);
            conResultado = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return arrLstSubcriterio;
    }

    public static ArrayList<UsuarioEntidad> llenarUsuario(ConjuntoResultado conResultado) throws Exception {
        ArrayList<UsuarioEntidad> arrLstSubcriterio = new ArrayList<>();
        UsuarioEntidad objUsuario;
        try {
            while (conResultado.next()) {
                objUsuario = new UsuarioEntidad(Long.parseLong(conResultado.getBigInteger(0).toString()),conResultado.getString(1),conResultado.getString(2),conResultado.getString(3),conResultado.getString(4),conResultado.getString(5),conResultado.getString(6));
                arrLstSubcriterio.add(objUsuario);
            }
        } catch (Exception e) {
            arrLstSubcriterio.clear();
            //  integracion.auditoria.log ublog = new integracion.auditoria.log();
            // ublog.write("Modulo", "llenarModulos", e.getClass().getName(), e.getMessage());
            throw e;
        }
        return arrLstSubcriterio;
    }

    public static int eliminarUsuario(long lonIdUsuarioEliminar) throws Exception {
        String strQuery = "select bd_st.fn_delete_usuario(?)";
        int intResultado = 0;
        ArrayList<Parametro> lisParametros = new ArrayList<>();
        lisParametros.add(new Parametro(1, lonIdUsuarioEliminar));
        ConjuntoResultado conResultado = AccesoDatos.ejecutaQuery(strQuery, lisParametros);
        while (conResultado.next()) {
            intResultado = conResultado.getInt(0);
        }
        return intResultado;
    }
}
