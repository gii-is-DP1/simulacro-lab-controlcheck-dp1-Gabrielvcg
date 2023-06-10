package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository repo;
    public ProductService(ProductRepository repo){
        this.repo=repo;
    }
   
    public List<ProductType> getAllProductTypes(){
        return null;
    }
    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return null;
    }

    public ProductType getProductType(String typeName) {
        return repo.findProductTypeByName(typeName);
    }

    public Product save(Product p){
        return null;       
    }

    
}