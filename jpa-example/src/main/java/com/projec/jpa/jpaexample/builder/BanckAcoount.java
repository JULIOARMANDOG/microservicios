package com.projec.jpa.jpaexample.builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BanckAcoount  {
    private double accountNumer;
    private String ownner;
    private  BanckAcoountType type;
    private double balance;
    private double interstRate;


}
