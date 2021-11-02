/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public class Pedido implements Serializable {

    int id;
    String alumno;
    String ciclo;
    String fecha;
    int productoId;
    String estado;

    public Pedido() {
    }

    public Pedido(int id, String alumno, String ciclo, String fecha, int productoId, String estado) {
        this.id = id;
        this.alumno = alumno;
        this.ciclo = ciclo;
        this.fecha = fecha;
        this.productoId = productoId;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", alumno=" + alumno + ", ciclo=" + ciclo + ", fecha=" + fecha + ", productoId=" + productoId + ", estado=" + estado + '}';
    }

}
