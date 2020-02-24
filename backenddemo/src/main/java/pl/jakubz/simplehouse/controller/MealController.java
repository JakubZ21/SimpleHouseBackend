package pl.jakubz.simplehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;
import pl.jakubz.simplehouse.service.MealService;

import java.util.List;

@Controller
@RequestMapping("/meals")
public class MealController {

    @Autowired
    MealService mealService;

    @PostMapping("/saveMeal")
    public String saveMeal(@ModelAttribute("meal") Meal meal)
    {
        Meal tempMeal = meal;
        if(tempMeal.getImgUrl()=="")
        {
            tempMeal.setImgUrl("default.jpg");
        }

        mealService.saveMeal(tempMeal);
        return "redirect:/";
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

    @GetMapping("/deleteMeal")
    public String deleteMeal(@RequestParam("mealId") int theId){

        mealService.delete(theId);

        return "redirect:/";
    }
}
