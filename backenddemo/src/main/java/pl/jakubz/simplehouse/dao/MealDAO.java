package pl.jakubz.simplehouse.dao;


import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;

import java.util.List;

public interface MealDAO {
    List<Meal> getMealList();

    List<Meal> getMealListByCategory(String category);

    List<Category> getCategories();

    void saveMeal(Meal meal);

    void delete(int theId);

    Meal getMeal(int theId);
}
