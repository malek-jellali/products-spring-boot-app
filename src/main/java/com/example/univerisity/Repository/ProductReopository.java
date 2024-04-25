package com.example.univerisity.Repository;

import com.example.univerisity.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductReopository extends JpaRepository<Product, Long  > {

    List<Product> findByNameContains(String mc);
    List<Product> findByPriceGreaterThan(double price);

    @Query("select p from Product p where p.name like :x ")
    List<Product> search(@Param("x")String mc);

    @Query("select p from Product p where p.price > :x ")
    List<Product> searchByPrice(@Param("x")double price );


}
