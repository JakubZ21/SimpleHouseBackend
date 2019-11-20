package pl.javasolutions.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.javasolutions.pojo.Product;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(Model model) {
        
        List<Product> products = getProducts();
        
        model.addAttribute("products", products);
        model.addAttribute("nick", "Jan");
        return "home";

    }
    
    private List<Product> getProducts(){
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
}
    