package pl.jakubz.simplehouse.service;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jakubz.simplehouse.dao.MealDAO;
import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;
import pl.jakubz.simplehouse.exception.CategoryNotFoundException;
import pl.jakubz.simplehouse.exception.MealNotFoundException;

@Service
public class MealServiceImpl implements MealService {
    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    MealDAO mealDAO;

    public MealServiceImpl() {
    }

    @Transactional
    public List<Meal> getMealList() {
        List<Meal> meals = this.mealDAO.getMealList();
        Iterator iterator = meals.iterator();

        while(iterator.hasNext()) {
            Meal meal = (Meal)iterator.next();
            meal.setEncoded64(meal.getImg());
        }

        return meals;
    }

    @Transactional
    public List<Meal> getMealListByCategory(long category) {
        List<Meal> meals = this.mealDAO.getMealListByCategory(category);
        Iterator iterator = meals.iterator();

        while(iterator.hasNext()) {
            Meal meal = (Meal)iterator.next();
            meal.setEncoded64(meal.getImg());
        }

        return meals;
    }

    @Transactional
    public List<Category> getCategories() {
        return this.mealDAO.getCategories();
    }

    @Transactional
    public int saveMeal(Meal meal) {
        return this.mealDAO.saveMeal(meal);
    }

    @Transactional
    public void deleteMeal(int theId) {
        try {
            this.mealDAO.deleteMeal(theId);
        } catch (Exception e) {
            throw new MealNotFoundException("Student id not found: " + theId);
        }
    }

    @Transactional
    public Meal getMeal(int theId) {
        Meal meal;
        try {
            meal = this.mealDAO.getMeal(theId);
            if (meal == null) {
                throw new MealNotFoundException("Student id not found: " + theId);
            }
        } catch (Exception e) {
            throw new MealNotFoundException("Student id not found: " + theId);
        }

        meal.setEncoded64(meal.getImg());
        return meal;
    }

    @Transactional
    public void saveCategory(Category category) {
        this.mealDAO.saveCategory(category);
    }

    @Transactional
    public void deleteCategory(int id) {
        try {
            this.mealDAO.deleteCategory(id);
        } catch (Exception e) {
            throw new CategoryNotFoundException("Category id not found: " + id);
        }
    }

    @Transactional
    public Category getCategory(int id) {
        try {
            Category category = this.mealDAO.getCategory(id);
            if (category == null) {
                throw new CategoryNotFoundException("Category id not found: " + id);
            } else {
                return category;
            }
        } catch (Exception e) {
            throw new CategoryNotFoundException("Category id not found: " + id);
        }
    }
}