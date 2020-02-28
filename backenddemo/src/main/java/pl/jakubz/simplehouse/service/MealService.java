package pl.jakubz.simplehouse.service;



import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;

import java.util.List;

public interface MealService {

     List<Meal> getMealList();

     List<Meal> getMealListByCategory(long category);

     List<Category> getCategories();

     void saveMeal(Meal meal);

     void deleteMeal(int theId);

     Meal getMeal(int theId);

    void saveCategory(Category category);

     void deleteCategory(int id);

    Category getCategory(int id);
}
