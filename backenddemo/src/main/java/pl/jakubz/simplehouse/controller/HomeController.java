package pl.jakubz.simplehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;
import pl.jakubz.simplehouse.service.MealService;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping
public class HomeController {
    //TODO Create error handling page

    Logger logger = Logger.getLogger(getClass().getName());
    //Injecting the MealService
    @Autowired
    MealService mealService;


    @GetMapping("/")
    public String showHome(Model model, @RequestParam(required = false, name = "categoryId") Integer catId)
    {
        List<Meal> meals;
        //listing the meals
        //logger.info(">>>CatID: "+catId);
        if (catId == null)
        {
             meals= mealService.getMealList();
        }else
        {
            meals=mealService.getMealListByCategory(catId);
        }
        model.addAttribute("meals", meals);
        List<Category> categories = mealService.getCategories();
        model.addAttribute("categories",categories);
        return "index";
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
