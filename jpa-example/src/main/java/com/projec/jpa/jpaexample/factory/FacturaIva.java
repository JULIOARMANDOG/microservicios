package com.projec.jpa.jpaexample.factory;

public class FacturaIva extends Factura{

    @Override
    public double getImporteIva() {
        return getImporte()*1.1;
    }


}
