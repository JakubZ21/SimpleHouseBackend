package pl.jakubz.simplehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;
import pl.jakubz.simplehouse.service.MealService;

import java.util.List;

@Controller
public class HomeController {

    //Injecting the MealService
    @Autowired
    MealService mealService;


    @GetMapping("/")
    public String showHome(Model model)
    {

        // TODO Get the meals from database

        //listing the meals
        List<Meal> meals = mealService.getMealList();
        model.addAttribute("meals", meals);
        return "index";
    }



    /*@GetMapping("/home")
    public String showHomeWithCategories(Model model, @RequestParam(name = "category")String category)
    {

        // TODO Get the meals from database
        //listing the meals
        List<Meal> meals = mealService.getMealListByCategory(category);

        model.addAttribute("meals", meals);
        return "index";
    }*/




    @GetMapping("/about")
    public String showAbout()
    {
        return "about";
    }

    @GetMapping("/contact")
    public String showContact()
    {
        return "contact";
    }

}
