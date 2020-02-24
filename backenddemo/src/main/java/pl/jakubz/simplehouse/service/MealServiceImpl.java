package pl.jakubz.simplehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jakubz.simplehouse.dao.MealDAO;
import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
public class MealServiceImpl implements MealService {

    Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    MealDAO mealDAO;



    @Override
    @Transactional
    public List<Meal> getMealList() {
        return mealDAO.getMealList();
    }

    @Override
    @Transactional
    public List<Meal> getMealListByCategory(String category) {
        return mealDAO.getMealListByCategory(category);
    }

    @Override
    @Transactional
    public List<Category> getCategories() {
        return mealDAO.getCategories();

    }

    @Override
    @Transactional
    public void saveMeal(Meal meal) {
        mealDAO.saveMeal(meal);
    }

    @Override
    @Transactional
    public void delete(int theId) {
        mealDAO.delete(theId);
    }

    @Override
    public Meal getMeal(int theId) {
        Meal meal = mealDAO.getMeal(theId);
        logger.info(meal.toString());
        return meal;
    }
}
