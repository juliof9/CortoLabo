/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class producto {
    private int cantidad;
    private String codigo;
    private String tipo;
    private int precio;
    private String nombre;
    private boolean disponibilidad;
    
    public producto(){
    }
    
    public producto(int cantidad,String codigo, String tipo, int precio, String nombre, boolean disponibilidad){
        this.codigo=codigo;
        this.cantidad=cantidad;
        this.tipo=tipo;
        this.precio=precio;
        this.nombre=nombre;
        this.disponibilidad=disponibilidad;
    }
    
    public producto(String codigo, String tipo, int precio, boolean disponibilidad){
        this.codigo = codigo;
        this.tipo = tipo;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        
    }
    
    public producto(String tipo, int precio, boolean disponibilidad){
        this.tipo=tipo;
        this.precio=precio;
        this.disponibilidad=disponibilidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
