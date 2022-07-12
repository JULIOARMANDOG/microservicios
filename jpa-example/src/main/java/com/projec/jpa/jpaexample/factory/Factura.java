package com.projec.jpa.jpaexample.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Factura {
    private int id;
    private double importe;
    public abstract double getImporteIva();
}
