/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.accesodatos;

import java.util.Locale;

/**
 *
 * @author Javier Romero
 * 
 */
public final class Global {

    Locale  lt = new Locale("es_ES");
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("ec.gob.tiwintza.accesodatos.database",lt);
    
    private String DRIVER = Configuracion.getString("driver");
    //cadena de conexion a la centralizada
    private String URL = Configuracion.getString("url");
    private String USER=  Configuracion.getString("user");
    private String PASS= Configuracion.getString("pasword");

    public Global() {
    }

    public final static int CANTIDADNOTICIASPAGINACION = 10;

    public String getDRIVER() {
        return DRIVER;
    }

    public void setDRIVER(String DRIVER) {
        this.DRIVER = DRIVER;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }

}
