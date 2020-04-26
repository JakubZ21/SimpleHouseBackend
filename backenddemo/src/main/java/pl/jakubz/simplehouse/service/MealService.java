
package pl.jakubz.simplehouse.service;

import java.util.List;
import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;

public interface MealService {
    List<Meal> getMealList();

    List<Meal> getMealListByCategory(long category);

    List<Category> getCategories();

    int saveMeal(Meal meal);

    void deleteMeal(int theId);

    Meal getMeal(int theId);

    void saveCategory(Category category);

    void deleteCategory(int id);

    Category getCategory(int id);
}
