package pl.jakubz.blogbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jakubz.blogbackend.dao.MealDAO;
import pl.jakubz.blogbackend.entity.Category;
import pl.jakubz.blogbackend.entity.Meal;

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
        logger.info(mealDAO.getMealList().toArray().toString());
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
        logger.info(mealDAO.getCategories().toArray().toString());
        return mealDAO.getCategories();

    }

    @Override
    @Transactional
    public void saveMeal(Meal meal) {
        mealDAO.saveMeal(meal);
    }
}
