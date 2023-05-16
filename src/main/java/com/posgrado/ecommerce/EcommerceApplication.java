package com.posgrado.ecommerce;

import com.posgrado.ecommerce.entity.Category;
import com.posgrado.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

  @Autowired
  CategoryRepository categoryRepository;

  public static void main(String[] args) {
    SpringApplication.run(EcommerceApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Category category = new Category();
    category.setName("SPORT");
    category.setDescription("Mochillas deportivas");

    Category category1 = new Category();
    category1.setName("TRAVEL");
    category1.setDescription("Mochillas para viajar");

    Category categorySaved = categoryRepository.save(category);
    Category category1Saved = categoryRepository.save(category1);
    System.out.println(categorySaved.getId().toString());
    System.out.println(category1Saved.getId().toString());
  }
}
