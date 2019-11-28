/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javasolutions.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javasolutions.manager.ProductManager;
import pl.javasolutions.pojo.Product;

/**
 *
 * @author QbeePC
 */
@Controller
public class ProductController {

    @Autowired // Po³¹czenie automatyczne z wstrzykniêtym beanem productManager
    private ProductManager productManager;

    @GetMapping(value = "/products/{category}")
    public String controller(Model model,@PathVariable("category") String category, @RequestParam(value="count", required = false, defaultValue = "1") String count) {
        
        List<Product> products = productManager.findByCategory(category);
        if(category.equals("ALL"))
        {
            products = productManager.findAll();
        }
        else
        {
            products = productManager.findByCategory(category);
        }
        products = getByCount(count, products);
        
        List<String> categories = productManager.getCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "products";
    }
    
    private List<Product> getByCount(String count, List<Product> products)
    {
        List<Product> result = new ArrayList<>();
        Integer countAsInt = Integer.valueOf(count);
        IntStream.range(0, countAsInt).forEach(index -> result.add(products.get(index)));
        return result;
    }
}
