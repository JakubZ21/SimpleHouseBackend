package pl.jakubz.simplehouse.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class MealDAOImpl implements MealDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Meal> getMealList() {
        //get current hibernate session
        Session session = entityManager.unwrap(Session.class);

        //create query
        Query<Meal> query = session.createQuery("from Meal",Meal.class);
        //execute query
        List<Meal> meals = query.getResultList();
        //return list
        //System.out.println(meals.toString());
        return meals;
    }

    @Override
    public List<Meal> getMealListByCategory(long categoryId) {
        Session session = entityManager.unwrap(Session.class);

        //create query based on category
        Query<Meal> query = session.createQuery("from Meal where category.id=:categoryId ");
        query.setParameter("categoryId",categoryId);

        return query.getResultList();
    }

    @Override
    public List<Category> getCategories() {

        Session session = entityManager.unwrap(Session.class);

        //create query
        Query<Category> query= session.createQuery("from Category", Category.class);
        return query.getResultList();
    }

    @Override
    public void saveMeal(Meal meal) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(meal);
    }

    @Override
    public void deleteMeal(int theId) {
        Session session = entityManager.unwrap(Session.class);
        Meal meal = session.get(Meal.class, (long)theId);
        session.delete(meal);
    }

    @Override
    public Meal getMeal(int theId) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Meal.class, (long)theId);
    }

    @Override
    public void saveCategory(Category category) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(category);
    }

    @Override
    public void deleteCategory(int id) {
        Session session = entityManager.unwrap(Session.class);
        Category category = session.get(Category.class,(long)id);
        session.delete(category);
    }

    @Override
    public Category getCategory(int id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Category.class,(long)id);
    }
}
