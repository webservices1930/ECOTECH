package com.javeriana.ecotech.entities;

public class Compra {
    private Cliente cliente;
    private Servicio servicio;
    private Boolean  is_commented;
    public static final String collection = "Compras";

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Boolean getIs_commented() {
        return is_commented;
    }

    public void setIs_commented(Boolean is_commented) {
        this.is_commented = is_commented;
    }
}
