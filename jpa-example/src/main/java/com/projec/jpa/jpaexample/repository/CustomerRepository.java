package com.projec.jpa.jpaexample.repository;

import com.projec.jpa.jpaexample.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//utilizamos interfaces para cumpplircon los principios solid
//S: Single Responsibility Principle Una clase debe tener una unica función
//O: Open-Closed Principle  Las clases deben estar abiertas a su extension pero cerradas a su modificación
//L: Liskov Substitution Principle Una clase deberia ser sustituible por su clase padre
//I: Interface Segregation Principle El cliente no debe estar sujeto a utilizar metodos que no usa
//D: Dependency Inversion Principle  Las clases de alto nivel no deberian depender de clases de bajo nivel
//ambas deberian depender de abstracciones
//las abstracciones no deberian depender de los detalles , los detalles deberian depender de las
// asbtracciones
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
   // List<Customer> findLastName(String lastName);
   // Customer findById(long id);
  @Query("select u from Customer u WHERE u.firstName = :firstName")
  Customer findByNameCustomer(@Param("firstName") String firstName);
}
