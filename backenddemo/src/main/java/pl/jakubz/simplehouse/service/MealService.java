package pl.jakubz.simplehouse.service;



import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;

import java.util.List;

public interface MealService {

    public List<Meal> getMealList();

    public List<Meal> getMealListByCategory(String category);

    public List<Category> getCategories();

    public void saveMeal(Meal meal);

    void delete(int theId);
}
