package pl.jakubz.simplehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;
import pl.jakubz.simplehouse.service.MealService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/meals")
public class MealController {

    @Autowired
    MealService mealService;
    //TODO Modify incoming data with aspects so it all looks uniform
    @PostMapping("/saveMeal")
    public String saveMeal(@Valid @ModelAttribute("meal") Meal meal, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            //creating model attribute
            //To show categories when somebody passes incorrect data
            List<Category> categories = mealService.getCategories();
            model.addAttribute("categories", categories);
            return "meal_form";
        }
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
        meal.setMealPrice(10.50f);
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

        mealService.deleteMeal(theId);

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
    public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "category_form";
        }
        mealService.saveCategory(category);

        return "redirect:/meals/categoryForm";
    }
    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam("id")int id)
    {
        mealService.deleteCategory(id);
        return "redirect:/meals/categoryForm";
    }
    @GetMapping("/renameCategory")
    public String renameCategory(@RequestParam("id")int id, Model model) {

        Category category = mealService.getCategory(id);
        model.addAttribute("category",category);
        //get categories from DB
        List<Category> categoryList = mealService.getCategories();
        //add to model
        model.addAttribute("categories", categoryList);
        return "category_form";
    }
}
