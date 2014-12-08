/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
/**
 *
 * @author Pablo
 */

public class Reloj implements Runnable {

    private static Reloj manejo;
    private JLabel label;
    private String hora, minutos, segundos, ampm;
    private Thread hilo;

    public Reloj() {
    }

    private static void createInstance() {
        synchronized (Reloj.class) {
            // En la zona sincronizada sería necesario volver
            // a comprobar que no se ha creado la instancia
            if (manejo == null) {
                manejo = new Reloj();
            }
        }
    }

    public static Reloj getInstance() {
        createInstance();
        return manejo;
    }

 
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void setReloj(JLabel label) {
        this.label = label;
        hilo = new Thread(this);
        hilo.start();
    }

    public void stop() {
        hilo = null;
    }

    @Override
    public void run() {
        while (Thread.currentThread() == hilo) {
            getHora();
            label.setText(getFecha() + ", " + hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    private String getFecha() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }

    private void getHora() {
        Calendar calendario = new GregorianCalendar();
        calendario.setTime(new Date());
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        int hor = calendario.get(Calendar.HOUR_OF_DAY);
        hora = ampm.equals("PM") ? (hor - 12) > 9 ? "" + (hor - 12) : "0" + (hor - 12)
                : calendario.get(hor) > 9 ? "" + calendario.get(hor) : "0" + calendario.get(hor);
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
}