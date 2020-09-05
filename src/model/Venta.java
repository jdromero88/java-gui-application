/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author jodarove
 */
public class Venta {
    private Date fechaHora;
    private BigDecimal total;
    private boolean anulado;

    public Venta() {
    }

    public Venta(Date fechaHora, BigDecimal total, boolean anulado) {
        this.fechaHora = fechaHora;
        this.total = total;
        this.anulado = anulado;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }
    
}
