package com.posgrado.ecommerce;

import com.posgrado.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

  @Autowired
  CategoryRepository categoryRepository;

  public static void main(String[] args) {
    SpringApplication.run(EcommerceApplication.class, args);
    System.out.println("SISTEMA INICIADO - EDWIN AGUILAR VERDUGUEZ");
  }
}
