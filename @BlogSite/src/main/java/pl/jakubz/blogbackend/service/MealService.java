package pl.jakubz.blogbackend.service;

import pl.jakubz.blogbackend.entity.Category;
import pl.jakubz.blogbackend.entity.Meal;

import java.util.List;

public interface MealService {

    public List<Meal> getMealList();

    public List<Meal> getMealListByCategory(String category);

    public List<Category> getCategories();

    public void saveMeal(Meal meal);
}
