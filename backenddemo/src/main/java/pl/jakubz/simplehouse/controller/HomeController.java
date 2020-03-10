
package pl.jakubz.simplehouse.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.service.MealService;

@Controller
@RequestMapping
public class HomeController {
    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    MealService mealService;

    public HomeController() {
    }

    @GetMapping({"/"})
    public String showHome(Model model, @RequestParam(required = false,name = "categoryId") Integer catId) {
        List meals;
        if (catId == null) {
            meals = this.mealService.getMealList();
        } else {
            meals = this.mealService.getMealListByCategory((long)catId);
        }

        model.addAttribute("meals", meals);
        List<Category> categories = this.mealService.getCategories();
        model.addAttribute("categories", categories);
        return "index";
    }

    @GetMapping({"/about"})
    public String showAbout() {
        return "about";
    }
}
