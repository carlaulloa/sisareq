/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ULLOA
 */
public class Tiempo {

    public static String transformDateToString(Date fecha){
        String strFecha ="";
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
        strFecha = fechaHora.format(fecha);
        return strFecha;
    }
    
    public static String transformFechaToFormatSql(String fechaVista) {
        String fechaSalida = fechaVista.replace('/', '-');
        String[] arr = fechaSalida.split("-");
        fechaSalida = arr[2] + "-" + arr[0] + "-" + arr[1];
        return fechaSalida;
    }

    public static Date formatearFecha(String strFecha) throws ParseException {
        Date date;
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        date = formateador.parse(strFecha);
        return date;
    }

    public static Date sumarRestarDiasFecha(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    public static Date getFecha() {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {

            // el obtener 
            Calendar fecha = new GregorianCalendar();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH) + 1;
            int dia = fecha.get(Calendar.DAY_OF_MONTH);

            String sAño = String.valueOf(año);
            String sMes = String.valueOf(mes);
            String sDia = String.valueOf(dia);

            if (mes < 10) {
                sMes = "0" + sMes;
            }
            if (dia < 10) {
                sDia = "0" + sDia;
            }

            String strFecha = sAño + "-" + sMes + "-" + sDia;
            date = formateador.parse(strFecha);
            System.out.println(date);
        } catch (ParseException ex) {

        }
        return date;
    }

    public static Date getHora() {
        Date fecha = new Date();
        System.out.println("Fecha  " + fecha);

        SimpleDateFormat formato = new SimpleDateFormat("hh:mm:ss");

        /*  String strHora = formato.format(fecha);
         System.out.println("Son las " + strHora);*/
        Date dHora = null;
        int hora, minutos, segundos;
        String sHora, sMinutos, sSegundos;
        try {

            // el obtener
            Calendar calendario = Calendar.getInstance();

            hora = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND);

            sHora = String.valueOf(hora);
            sMinutos = String.valueOf(minutos);
            sSegundos = String.valueOf(segundos);

            if (hora < 10) {
                sHora = "0" + sHora;
            }
            if (minutos < 10) {
                sMinutos = "0" + sMinutos;
            }
            if (segundos < 10) {
                sSegundos = "0" + sSegundos;
            }

            String strHora = sHora + ":" + sMinutos + ":" + sSegundos;
            System.out.println(strHora);
            dHora = formato.parse(strHora);
            System.out.println(dHora);
        } catch (ParseException ex) {

        }
        return dHora;
    }

}
