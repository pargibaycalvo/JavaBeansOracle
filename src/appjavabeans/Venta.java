/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appjavabeans;

import java.sql.Date;

/**
 *
 * @author oracle
 */
public class Venta {

    private int id;
    private int idproducto;
    private java.sql.Date fechaventa;
    private int cantidad;

    public Venta() {
    }

    public Venta(int id, int idproducto, Date fechaventa, int cantidad) {
        this.id = id;
        this.idproducto = idproducto;
        this.fechaventa = fechaventa;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", idproducto=" + idproducto + ", fechaventa=" + fechaventa + ", cantidad=" + cantidad + '}';
    }
}
