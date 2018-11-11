/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastian
 */
public class Detalle_cap {
private int id_detalle;
private String fecha;
private int id_capacitacion;

    public Detalle_cap() {
    }

    public Detalle_cap(int id_detalle, String fecha, int id_capacitacion) {
        this.id_detalle = id_detalle;
        this.fecha = fecha;
        this.id_capacitacion = id_capacitacion;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_capacitacion() {
        return id_capacitacion;
    }

    public void setId_capacitacion(int id_capacitacion) {
        this.id_capacitacion = id_capacitacion;
    }





}
