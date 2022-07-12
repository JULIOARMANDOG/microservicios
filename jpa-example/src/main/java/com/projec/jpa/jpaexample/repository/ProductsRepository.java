package com.projec.jpa.jpaexample.repository;

import com.projec.jpa.jpaexample.data.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ProductsRepository extends JpaRepository<Productos, Serializable> {


}
