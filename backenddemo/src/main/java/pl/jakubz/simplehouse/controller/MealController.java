
package pl.jakubz.simplehouse.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;
import pl.jakubz.simplehouse.exception.FileTooBigException;
import pl.jakubz.simplehouse.service.MealService;

@Controller
@RequestMapping({"/meals"})
public class MealController {
    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    MealService mealService;
    @Autowired
    ResourceLoader resourceLoader;

    public MealController() {
    }

    @PostMapping({"/saveMeal"})
    public String saveMeal(@ModelAttribute("hasImage") String hasImageString, @ModelAttribute("file") MultipartFile file, @Valid @ModelAttribute("meal") Meal meal, BindingResult bindingResult, Model model) throws IOException {
        int hasImage = Integer.parseInt(hasImageString);
        if (bindingResult.hasErrors()) {
            List<Category> categories = this.mealService.getCategories();
            model.addAttribute("categories", categories);
            return "meal_form";
        } else {
            byte[] img;
            if (!file.isEmpty() && hasImage == 1) {
                try {
                    img = file.getBytes();
                    if (img.length > 64000) {
                        throw new FileTooBigException("File is too big. Max 64KB");
                    }

                    meal.setImg(img);
                    meal.setEncoded64(meal.getImg());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (!file.isEmpty() && hasImage == 0) {
                img = file.getBytes();
                if (img.length > 64000) {
                    throw new FileTooBigException("File is too big. Max 64KB");
                }

                meal.setImg(img);
            } else if (!file.isEmpty() || hasImage != 1) {
                try {
                    Resource resource = this.resourceLoader.getResource("classpath:default.jpg");
                    byte[] defImg = FileCopyUtils.copyToByteArray(resource.getInputStream());
                    meal.setImg(defImg);
                    meal.setEncoded64(meal.getImg());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            this.mealService.saveMeal(meal);
            return "redirect:/";
        }
    }

    @GetMapping({"/mealForm"})
    public String showMealForm(Model model) {
        Meal meal = new Meal();
        meal.setMealPrice(10.5F);
        List<Category> categories = this.mealService.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("meal", meal);
        return "meal_form";
    }

    @GetMapping({"/mealUpdateForm"})
    public String showMealForm(@RequestParam("mealId") int theId, Model model) throws IOException {
        Meal meal = this.mealService.getMeal(theId);
        List<Category> categories = this.mealService.getCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("meal", meal);
        Resource resource = this.resourceLoader.getResource("classpath:default.jpg");
        byte[] defImg = FileCopyUtils.copyToByteArray(resource.getInputStream());
        String defImage = Base64.getEncoder().encodeToString(defImg);
        model.addAttribute("defImage", defImage);
        return "meal_form";
    }

    @GetMapping({"/deleteMeal"})
    public String deleteMeal(@RequestParam("mealId") int theId) {
        this.mealService.deleteMeal(theId);
        return "redirect:/";
    }

    @GetMapping({"/categoryForm"})
    public String showCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        List<Category> categoryList = this.mealService.getCategories();
        model.addAttribute("categories", categoryList);
        return "category_form";
    }

    @PostMapping({"/saveCategory"})
    public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Category> categoryList = this.mealService.getCategories();
            model.addAttribute("categories", categoryList);
            return "category_form";
        } else {
            category.setCategory(StringUtils.capitalize(category.getCategory().toLowerCase()));
            this.mealService.saveCategory(category);
            return "redirect:/";
        }
    }

    @GetMapping({"/deleteCategory"})
    public String deleteCategory(@RequestParam("id") int id) {
        this.mealService.deleteCategory(id);
        return "redirect:/meals/categoryForm";
    }

    @GetMapping({"/renameCategory"})
    public String renameCategory(@RequestParam("id") int id, Model model) {
        Category category = this.mealService.getCategory(id);
        model.addAttribute("category", category);
        List<Category> categoryList = this.mealService.getCategories();
        model.addAttribute("categories", categoryList);
        return "category_form";
    }
}