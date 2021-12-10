package com.utxj.mieconomia;

import java.util.Date;

public class Movimiento {

    Date fecha = new Date();
    String motivo;
    Double monto;
    Boolean tipo = true;

    public Movimiento() {
    }

    public Movimiento(String motivo, Double monto) {
        this.motivo = motivo;
        this.monto = monto;
    }

    public Movimiento(Date fecha, String motivo, Double monto, Boolean tipo) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.monto = monto;
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }
}
