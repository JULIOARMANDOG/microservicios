package com.projec.jpa.jpaexample.factory;

public class FacturaIvaReducido extends Factura{



    @Override
    public double getImporteIva() {
        return getImporte() * 10;
    }
}
