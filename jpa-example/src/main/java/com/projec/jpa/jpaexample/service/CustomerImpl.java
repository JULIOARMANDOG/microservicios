package com.projec.jpa.jpaexample.service;

import com.projec.jpa.jpaexample.data.Customer;
import com.projec.jpa.jpaexample.data.CustomerDto;
import com.projec.jpa.jpaexample.repository.CustomerRepository;
import com.projec.jpa.jpaexample.repository.ProductsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerImpl implements ICustomerServices{
@Autowired
    CustomerRepository customerRepository;
@Autowired
    ProductsRepository productsRepository;
@Autowired
    ModelMapper modelmapper;


    @Override
    public List<CustomerDto> listaCustomer() {
        List<Customer> listaCustomer=(List<Customer>)customerRepository.findAll();
        List<CustomerDto> listDtoCustomer=listaCustomer.stream().map(customer -> mapToDTO(customer)).collect(Collectors.toList());
        return listDtoCustomer;
    }



    @Override
    public CustomerDto crearCustomer(CustomerDto customerdto) {
        Customer c=mapToEntity(customerdto);
        Customer cnew=customerRepository.save(c);
        CustomerDto customerResponse=mapToDTO(cnew);
        return customerResponse;
    }

    @Override
    public CustomerDto consultarByNombre(String firstName) {
       Customer cut=customerRepository.findByNameCustomer(firstName);
        CustomerDto custdto=mapToDTO(cut);
        return custdto;

    }

    private CustomerDto mapToDTO(Customer post){
        CustomerDto custDto = modelmapper.map(post, CustomerDto.class);
        return custDto;
    }
    private Customer mapToEntity(CustomerDto customerdto){
        Customer customer = modelmapper.map(customerdto, Customer.class);

        return customer;
    }

   /* private List<ProductoDto> listaProducto(Customer cust){
        List<Productos> lstproductos=productsRepository.findByCustomer(cust.getId());
        for(Productos)
        //lstProductDto =
    }*/
}
