package pl.javasolutions.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.javasolutions.pojo.Product;

@Controller//Pozwala na mapowanie
public class HomeController {

    @RequestMapping(value = "/") //Maping pliku home.jsp na stronê g³ówn¹
    public String home(Model model) {
        return "home";

    }
    
    
}
    