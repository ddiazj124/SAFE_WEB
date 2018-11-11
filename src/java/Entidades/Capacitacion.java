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
public class Capacitacion {
private int id_capacitacion;
private String nombre_capacitación;
private String fecha_termino;
private String fecha_inicio;
private int id_area;
private int id_plan;

    public Capacitacion() {
    }

    public Capacitacion(int id_capacitacion, String nombre_capacitación, String fecha_termino, String fecha_inicio, int id_area, int id_plan) {
        this.id_capacitacion = id_capacitacion;
        this.nombre_capacitación = nombre_capacitación;
        this.fecha_termino = fecha_termino;
        this.fecha_inicio = fecha_inicio;
        this.id_area = id_area;
        this.id_plan = id_plan;
    }

    public int getId_capacitacion() {
        return id_capacitacion;
    }

    public void setId_capacitacion(int id_capacitacion) {
        this.id_capacitacion = id_capacitacion;
    }

    public String getNombre_capacitación() {
        return nombre_capacitación;
    }

    public void setNombre_capacitación(String nombre_capacitación) {
        this.nombre_capacitación = nombre_capacitación;
    }

    public String getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(String fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }


}
