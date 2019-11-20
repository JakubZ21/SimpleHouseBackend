/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javasolutions.pojo;

/**
 *
 * @author QbeePC
 */
public class Product {
    private String category;
    private String name;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String category, String name) {
        this.category = category;
        this.name = name;
    }
    
    
    
    
}
