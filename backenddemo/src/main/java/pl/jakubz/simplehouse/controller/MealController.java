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
        if(meal.getImgUrl().equals(""))
        {
            meal.setImgUrl("default.jpg");
        }
        meal.setMealId(meal.getMealId());

        mealService.saveMeal(meal);
        return "redirect:/";
    }

    @GetMapping("/mealForm")
    public String showMealForm(Model model)
    {
        //creating model attribute
        Meal meal = new Meal();
        List<Category> categories = mealService.getCategories();
        model.addAttribute("categories", categories);

        //adding Meal to model attribute so i can work on it
        model.addAttribute("meal", meal);
        return "meal_form";
    }

    @GetMapping("/mealUpdateForm")
    public String showMealForm(@RequestParam("mealId") int theId, Model model)
    {
        //creating model attribute
        Meal meal = mealService.getMeal(theId);
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

    //
    //CATEGORIES RELATED
    //

    @GetMapping("/categoryForm")
    public String showCategoryForm(Model model){

        //create blank category
        Category category = new Category();
        //add it to model
        model.addAttribute("category", category);

        //get categories from DB
        List<Category> categoryList = mealService.getCategories();
        //add to model
        model.addAttribute("categories", categoryList);

        return "category_form";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("category") Category category)
    {
        mealService.saveCategory(category);

        return "redirect:/meals/categoryForm";
    }
}
