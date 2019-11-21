/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javasolutions.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/products")
    public String controller(Model model) {
        List<Product> products = productManager.findAll();
        List<String> categories = productManager.getCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "productsmine";
    }
}
