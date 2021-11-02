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
public class Carta implements Serializable{
    int id;
    String producto;
    Short disponible;
    int precio;
    String tipo;

    public Carta() {
    }

    public Carta(int id, String producto, Short disponible, int precio, String tipo) {
        this.id = id;
        this.producto = producto;
        this.disponible = disponible;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Short getDisponible() {
        return disponible;
    }

    public void setDisponible(Short disponible) {
        this.disponible = disponible;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Carta{" + "id=" + id + ", producto=" + producto + ", disponible=" + disponible + ", precio=" + precio + ", tipo=" + tipo + '}';
    }
    
    
}
