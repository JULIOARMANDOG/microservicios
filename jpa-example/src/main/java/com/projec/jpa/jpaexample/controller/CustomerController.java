package com.projec.jpa.jpaexample.controller;

import com.projec.jpa.jpaexample.builder.BanckAcoount;
import com.projec.jpa.jpaexample.builder.BanckAcoountType;
import com.projec.jpa.jpaexample.builder.BanckAcountBuilder;
import com.projec.jpa.jpaexample.data.CustomerDto;
import com.projec.jpa.jpaexample.factory.FactoryFacturas;
import com.projec.jpa.jpaexample.factory.Factura;
import com.projec.jpa.jpaexample.service.ICustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tienda")
public class CustomerController {



@Autowired
ICustomerServices customerService;




@GetMapping("/clientes")
public ResponseEntity<Object> getCustomers(){
    return new ResponseEntity<>(customerService.listaCustomer(), HttpStatus.OK) ;
}

@PostMapping("/save")
public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
    return new ResponseEntity<>(customerService.crearCustomer(customerDto),HttpStatus.CREATED);
}

    @GetMapping("/uncliente/{name}")
    public ResponseEntity<CustomerDto> getOneCustomer(@PathVariable String name){
        return new ResponseEntity<>(customerService.consultarByNombre(name), HttpStatus.OK) ;
    }


    @GetMapping("/cuentas")
    public ResponseEntity<BanckAcoount> getCuentas(){

        BanckAcountBuilder builder=new BanckAcountBuilder(123456);
        BanckAcoount backaccount=builder.withBalance(200)
                .withOwnner("armando")
                .withInterestRate(10.15)
                .withType(BanckAcoountType.CLIENTE_ESPECIAL)
                .build();

        return new ResponseEntity<>(backaccount, HttpStatus.OK) ;
    }


    @GetMapping("/facturas")
    public ResponseEntity<Factura> getFacturas(){

        Factura f= FactoryFacturas.getFactura("iva");
        f.setId(1);
        f.setImporte(20.5);
        return new ResponseEntity<>(f, HttpStatus.OK) ;
    }




}
