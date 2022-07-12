package com.projec.jpa.jpaexample.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CustomerDto {

    private String firstName;
    private String lastName;
    private Set<ProductoDto> productList;
   // private List<Productos> productList;

}
