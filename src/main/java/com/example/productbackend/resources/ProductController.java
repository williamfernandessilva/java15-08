package com.example.productbackend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productbackend.entities.Product;
import com.example.productbackend.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

     @Autowired
     private ProductService service;

     @GetMapping
     public ResponseEntity<List<Product>> getProducts(){

          var products = this.service.getProducts();
          return ResponseEntity.ok(products);

     }
    

     @GetMapping ("{id}")
     public ResponseEntity<Product> getProduct(@PathVariable long id){
           var product = this.service.getProduct(id);
           return ResponseEntity.ok(product);
     }

     @DeleteMapping ("{id}")
     public ResponseEntity<Void> deleteProduct(@PathVariable long id){
           this.service.deleteProductById(id);
           return ResponseEntity.noContent().build();
     }

      @PostMapping 
     public ResponseEntity<Product> save(@RequestBody Product product){
       var saveProduct = this.service.save(product);


       URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProduct.getId())
                .toUri();

       return ResponseEntity.created(location).body(saveProduct);
     
     }

     @PutMapping ("{id}")
     public ResponseEntity<product> update(RequestBody Product product,
                                    @PathVariable long id
     
     ){
      this.service.update(id, product);
      return ResponseEntity.ok().build();

     }

     
}
