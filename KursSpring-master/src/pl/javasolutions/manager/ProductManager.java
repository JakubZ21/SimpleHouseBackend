/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javasolutions.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import pl.javasolutions.pojo.Product;

/**
 *
 * @author QbeePC
 */
@Component
public class ProductManager {

    private List<Product> products;

    public ProductManager() {
        this.products = prepareProducts();
    }

    private List<Product> prepareProducts() {
        List<Product> products = new ArrayList<>();
        Product prod = new Product("koszulki", "koszulka1");
        Product secondProd = new Product("koszulki", "koszulka2");
        Product thirdProd = new Product("spodnie", "spodnie1");
        Product forthProd = new Product("spodnie", "spodnie2");
        products.add(prod);
        products.add(secondProd);
        products.add(thirdProd);
        products.add(forthProd);
        return products;
    }

    public List<Product> findAll() {
        return products;
    }

    public List<Product> findByCategory(String categoryName) {
        return products.stream()
                .filter(product -> categoryMatch(categoryName, product))
                .collect(Collectors.toList());
    }

    private boolean categoryMatch(String category, Product product) {
        String productCategory = product.getCategory();
        return category.equals(productCategory);
    }

    public List<String> getCategories() {

        List<String> result = new ArrayList<>();
        result.add("koszulki");
        result.add("spodnie");
        return result;
    }

}
