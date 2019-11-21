/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javasolutions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.javasolutions.pojo.User;

/**
 *
 * @author QbeePC
 */
@Controller
@SessionAttributes("loggedUser") //Atrybut sesji - zapisywany do sesji
public class LoginController {
    
    @PostMapping(value="/login")
    public String postLogin(Model model, @ModelAttribute("user") User user) //Pobranie wartoœci Obiektu user przez metodê Post
    {
        model.addAttribute("loggedUser", user); // Dodawanie atrybutu do sesji typu user
        return "redirect:user_page"; //redirect:by przekierowaæ na adres strony. Domyœnie return podmienia widok
    }
    
    @GetMapping(value="/login") //Pobranie wartoœci Obiektu user przez metodê Get
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }
}
