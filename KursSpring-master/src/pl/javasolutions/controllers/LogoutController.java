/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javasolutions.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author QbeePC
 */
@Controller
public class LogoutController {
    @GetMapping(value="/logout")
    public String userPage(Model model, HttpSession session){
        
        session.invalidate();//Wyrzuca obiekty z sesji
        return "redirect:/";
    }
    
}
