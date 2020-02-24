package pl.jakubz.blogbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jakubz.blogbackend.entity.Category;
import pl.jakubz.blogbackend.entity.Meal;
import pl.jakubz.blogbackend.service.MealService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    //Injecting the MealService
    @Autowired
    MealService mealService;


    @GetMapping("/home")
    public String showHome(Model model)
    {

        // TODO Get the meals from database

        //listing the meals
        List<Meal> meals = mealService.getMealList();
        model.addAttribute("meals", meals);
        return "index";
    }

    @GetMapping("/addNewMeal")
    public String showAddNewMealForm(Model model)
    {
        //creating model attribute
        Meal meal = new Meal();
        List<Category> categories = mealService.getCategories();
        model.addAttribute("categories", categories);



        //adding Meal to model attribute so i can work on it
        model.addAttribute("meal", meal);
        return "meal_form";
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

    @PostMapping("/saveMeal")
    public String saveMeal(@ModelAttribute("meal") Meal meal)
    {
        Meal tempMeal = meal;


        mealService.saveMeal(meal);
        return "redirect:/home";
    }


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
