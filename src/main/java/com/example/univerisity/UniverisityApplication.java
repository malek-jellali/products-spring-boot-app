package com.example.univerisity;

import com.example.univerisity.Repository.ProductReopository;
import com.example.univerisity.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniverisityApplication implements CommandLineRunner {

    @Autowired
    private ProductReopository productReopository;
    public static void main(String[] args) {
        SpringApplication.run(UniverisityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
productReopository.save(new Product(null , "computer", 4356 , 3));
productReopository.save(new Product(null , "phone", 1234 , 1));
productReopository.save(new Product(null , "printer", 456 , 3));
List<Product> products = productReopository.findAll();
products.forEach(p->{
    System.out.println(p.toString());
});
Product product=productReopository.findById(Long.valueOf(1)).get();
        System.out.println("*****************");
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("*****************");
        List<Product> productList=productReopository.findByNameContains("c");
        productList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("*****************");
        List<Product> productList2=productReopository.search("%c%");
        productList.forEach(p->{
            System.out.println(p);
        });
        System.out.println("*****************");
        List<Product> productList3=productReopository.findByPriceGreaterThan(3000);
        productList.forEach(p->{
            System.out.println(p);
        });

        System.out.println("*****************");
        List<Product> productList4=productReopository.searchByPrice(3000);
        productList.forEach(p->{
            System.out.println(p);
        });
    }

}
