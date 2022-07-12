package com.projec.jpa.jpaexample.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    //@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)  // SOLO PARA DESARROLLO
   // @Id @GeneratedValue(strategy = GenerationType.TABLE)
  //  @TableGenerator(name = "Cus_Gen")
   /* @TableGenerator(name = "Cus_Gen",
    table = "ID_GEN",
    pkColumnName = "GEN_NAME",
    valueColumnName = "GEN_VAL",
    pkColumnValue = "Custmer_Gen"
    )
    @Id @GeneratedValue(generator = "Cus_Gen" )*/
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer" , cascade = CascadeType.ALL)
    private Set<Productos> productList=new HashSet<>();

    @Enumerated(EnumType.STRING)
    private TypeCustomer tipocliente;




    @Override //Anula el metodo toString() de la clase Object para poder tener una salida las adecuada
    public String toString(){
        return String.format("Customer[id=%, firstName='%s', lastName='%s']",id,firstName,lastName);
    }



}
