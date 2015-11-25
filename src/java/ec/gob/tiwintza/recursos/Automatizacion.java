/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.recursos;

import ec.gob.tiwintza.controladores.Tramite_seguimiento_correoControlador;
import ec.gob.tiwintza.entidades.Tramite_seguimiento_correoEntidad;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timer;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author WMOINA
 */
@Singleton
public class Automatizacion {

    private Timer _timer;

    private Tramite_seguimiento_correoEntidad objTramite_seguimiento_correo;
    private Tramite_seguimiento_correoEntidad objSedTramite_seguimiento_correo;
    private Tramite_seguimiento_correoControlador objConTramite_seguimiento_correo;
    private ArrayList<Tramite_seguimiento_correoEntidad> arrLisTramite_seguimiento_correo;

    private String toEmail;
    private String messaje;
    private String subject;
    @EJB
    private Enviar_correo objEnviar_correo;

    //<editor-fold defaultstate="collapsed" desc="Datos del remitente">
    String fromEmail = "wilmermoinacs@gmail.com";
    String username = "wilmermoinacs";
    String password = "maycolrivera3";

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Sets y Gets">
    public void setObjConTramite_seguimiento_correo(Tramite_seguimiento_correoControlador objConTramite_seguimiento_correo) {
        this.objConTramite_seguimiento_correo = objConTramite_seguimiento_correo;
    }

    public Timer getTimer() {
        return _timer;
    }

    public void setTimer(Timer _timer) {
        this._timer = _timer;
    }

    public Tramite_seguimiento_correoEntidad getObjTramite_seguimiento_correo() {
        return objTramite_seguimiento_correo;
    }

    public void setObjTramite_seguimiento_correo(Tramite_seguimiento_correoEntidad objTramite_seguimiento_correo) {
        this.objTramite_seguimiento_correo = objTramite_seguimiento_correo;
    }

    public Tramite_seguimiento_correoEntidad getObjSedTramite_seguimiento_correo() {
        return objSedTramite_seguimiento_correo;
    }

    public void setObjSedTramite_seguimiento_correo(Tramite_seguimiento_correoEntidad objSedTramite_seguimiento_correo) {
        this.objSedTramite_seguimiento_correo = objSedTramite_seguimiento_correo;
    }

    public ArrayList<Tramite_seguimiento_correoEntidad> getArrLisTramite_seguimiento_correo() {
        return arrLisTramite_seguimiento_correo;
    }

    public void setArrLisTramite_seguimiento_correo(ArrayList<Tramite_seguimiento_correoEntidad> arrLisTramite_seguimiento_correo) {
        this.arrLisTramite_seguimiento_correo = arrLisTramite_seguimiento_correo;
    }

    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Automatizacion(Timer _timer, Tramite_seguimiento_correoEntidad objTramite_seguimiento_correo, Tramite_seguimiento_correoEntidad objSedTramite_seguimiento_correo, ArrayList<Tramite_seguimiento_correoEntidad> arrLisTramite_seguimiento_correo) {

        this._timer = _timer;
        this.objTramite_seguimiento_correo = objTramite_seguimiento_correo;
        this.objSedTramite_seguimiento_correo = objSedTramite_seguimiento_correo;
        this.arrLisTramite_seguimiento_correo = arrLisTramite_seguimiento_correo;
    }

    public Automatizacion() {
        objTramite_seguimiento_correo = new Tramite_seguimiento_correoEntidad();
        objSedTramite_seguimiento_correo = new Tramite_seguimiento_correoEntidad();
        arrLisTramite_seguimiento_correo = new ArrayList<>();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Funciones">
    @Schedule(hour = "*", minute = "*", second = "*/6")
    public void callMe(Timer t) throws Exception {
        arrLisTramite_seguimiento_correo = Tramite_seguimiento_correoControlador.cargarTramite_correos();
        _timer = t;
        try {
            for (Tramite_seguimiento_correoEntidad objTSC : arrLisTramite_seguimiento_correo) {
                messaje = "<!DOCTYPE html>\n"
                        + "<html lang=\"en\">\n"
                        + "<head>\n"
                        + "<meta charset=\"utf-8\">\n"
                        + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "<meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\n"
                        + "<title>NOTIFICACION SYSTRACK</title>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "<div style=\"background-image:url('http://3.bp.blogspot.com/-BcVOhjpTY4c/VlKvuR5uY9I/AAAAAAAAAXs/jlfksblZTSA/s1600/notificacion_correo.PNG');padding:1px;width:488px;height:674px;\"><br><br><br><br><br><br><br><br><blockquote><font face=\"verdana\" size=\"2\">\n"
                        + "     &nbsp;&nbsp;Se&ntilde;ores(a):\n"
                        + "     <b><br>&nbsp;&nbsp;&nbsp;DEL DEPARTAMENTO DE \"" + objTSC.getDepartamento_nombre() + "\"</b>\n"
                        + "     <br><br>&nbsp;&nbsp;&nbsp;Reciba un cordial saludo del Asesor Virtual SysTrack.\n"
                        + "     <br><br>\n"
                        + "    &nbsp; &nbsp;Le informamos que el tiempo de respuesta estimado para &nbsp;&nbsp;&nbsp;tr&aacute;mite con:\n"
                        + "   <br><br>\n"
                        + "   <font face=\"verdana\" size=\"2\" color=\"#848484\">\n"
                        + "     <b>&nbsp;&nbsp;&nbsp;Nombre:</b></font>\n"
                        + "    <br>&nbsp;&nbsp;<textarea lang=\"en-US\" rows=\"3\" cols=\"45\" readonly Style=\"font-family: Verdana;text-align:justify;border:0px\">" + objTSC.getComentario_tramite_descripcion() + "\n"
                        + "	</textarea>\n"
                        + "     <br>\n"
                        + "     <font face=\"verdana\" size=\"2\" color=\"#848484\">\n"
                        + "     <b>&nbsp;&nbsp;&nbsp;C&oacute;digo:</b></font>&nbsp;" + objTSC.getTramite_id() + ""
                        + "    <br>&nbsp;&nbsp;&nbsp;ha culminado.\n"
                        + "     <br><br>&nbsp; &nbsp;Agradecemos por su pronta atenci&oacute;n y el registro de la  &nbsp;&nbsp;&nbsp;soluci&oacute;n &nbsp;&nbsp;correspondiente en el sistema <a href=\"http://www.tiwintza.gob.ec/\">Ir</a>.\n"
                        + "    <br><br><b>&nbsp;&nbsp;&nbsp; Asesor Virtual,</b>\n"
                        + "     <br>&nbsp;&nbsp;&nbsp;SysTrack\n"
                        + "  </font>\n"
                        + "  <font face=\"verdana\" size=\"1.9\" color=\"#848484\" style=\"text-align: center\">\n"
                        + "    <br><br><br><br><br>\n"
                        + "    <br><p aling=\"Right\">GOBIERNO AUT&Oacute;NOMO DESCENTRALIZADO MUNICIPAL DE TIWINTZA\n"
                        + "    <br><a href=\"http://www.tiwintza.gob.ec/\">Visite el sitio web</a>\n"
                        + "    <br>Direcci&oacute;n:\n"
                        + "    <br>Frente al parque central del cant&oacute;n Tiwintza\n"
                        + "    <br>Contacto:\n"
                        + "    <br>Tel:(07)3058456 - ext 104\n"
                        + "     <br>sistemas@tiwintza.gob.ec\n"
                        + "    </p>\n"
                        + "  </font>\n"
                        + "</blockquote>\n"
                        + "</div>\n"
                        + "</body>\n"
                        + "</html>";
                subject = "NOTIFICACION SYSTRACK CODIGO " + objTSC.getTramite_id() + "";
                toEmail = objTSC.getUsuario_email();
                objEnviar_correo.EnviarEmail(fromEmail, username, password, toEmail, subject, messaje);
                Tramite_seguimiento_correoControlador.eliminarCorreo(objTSC.getTramite_id());
                System.out.println("*****************************************");
            }
        } catch (EJBException e) {
            throw e;
        }
    }

    public void cancelar() {
        _timer.cancel();
        System.out.println("cancelado");
    }
    //</editor-fold>
}
