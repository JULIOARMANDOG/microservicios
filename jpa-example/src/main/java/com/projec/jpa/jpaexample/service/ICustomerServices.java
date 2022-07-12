package com.projec.jpa.jpaexample.service;

import com.projec.jpa.jpaexample.data.CustomerDto;

import java.util.List;

public interface ICustomerServices {
    public List<CustomerDto> listaCustomer();
    CustomerDto crearCustomer(CustomerDto customerdto);

    public CustomerDto consultarByNombre(String firstName);
}
