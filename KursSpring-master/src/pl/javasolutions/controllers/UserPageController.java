/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javasolutions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.javasolutions.pojo.User;

/**
 *
 * @author QbeePC
 */

@Controller
public class UserPageController {
    
    @GetMapping(value="/user_page")
    public String userPage(Model model, @SessionAttribute("loggedUser") User user){//SessionAtt przechwytuje atrybut logged user
        model.addAttribute("usr", user); //nazwa atrybutu usr poniewa¿ mamy ju¿ atrybut o nazwie user
        
        return "user_page";
    }
    
    
}
