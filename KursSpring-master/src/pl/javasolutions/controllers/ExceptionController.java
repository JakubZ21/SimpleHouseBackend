/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javasolutions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author QbeePC
 */

@ControllerAdvice // Dzieki temu dziala przechwytywanie wyj¹tków
public class ExceptionController {
    
    @RequestMapping("/runtimeException")
    private String runtimeException()
    {
        throw new RuntimeException();
    }
    
    @ExceptionHandler(Exception.class) //Dla Jakiegokolwiek wyj¹tku wyrzuca strone handleException.jsp
    public String handleException(Exception e)
    {
     return "handleException";   
    }
}
