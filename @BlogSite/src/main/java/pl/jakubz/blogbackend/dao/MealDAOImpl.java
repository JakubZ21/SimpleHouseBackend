package pl.jakubz.blogbackend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.jakubz.blogbackend.entity.Category;
import pl.jakubz.blogbackend.entity.Meal;

import java.util.List;

@Repository
public class MealDAOImpl implements MealDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Meal> getMealList() {
        //get current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //create query
        Query<Meal> query = session.createQuery("from Meal",Meal.class);
        //execute query
        List<Meal> meals = query.getResultList();
        //return list
        System.out.println(meals.toString());
        return meals;
    }

    @Override
    public List<Meal> getMealListByCategory(String category) {

      return null;
    }

    @Override
    public List<Category> getCategories() {

        Session session = sessionFactory.getCurrentSession();

        //create query
        Query<Category> query= session.createQuery("from Category", Category.class);
        List<Category> categories= query.getResultList();
        return categories;
    }

    @Override
    public void saveMeal(Meal meal) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(meal);
    }
}
