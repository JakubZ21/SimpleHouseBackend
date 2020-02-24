package pl.jakubz.blogbackend.dao;

import pl.jakubz.blogbackend.entity.Category;
import pl.jakubz.blogbackend.entity.Meal;

import java.util.List;

public interface MealDAO {
    List<Meal> getMealList();

    List<Meal> getMealListByCategory(String category);

    List<Category> getCategories();

    void saveMeal(Meal meal);
}
