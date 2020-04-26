package pl.jakubz.simplehouse.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.jakubz.simplehouse.entity.Category;
import pl.jakubz.simplehouse.entity.Meal;

@Repository
public class MealDAOImpl implements MealDAO {
    @Autowired
    private EntityManager entityManager;

    public MealDAOImpl() {
    }

    public List<Meal> getMealList() {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        Query<Meal> query = session.createQuery("from Meal", Meal.class);
        List<Meal> meals = query.getResultList();
        return meals;
    }

    public List<Meal> getMealListByCategory(long categoryId) {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        Query<Meal> query = session.createQuery("from Meal where category.id=:categoryId ");
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    public List<Category> getCategories() {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        Query<Category> query = session.createQuery("from Category", Category.class);
        return query.getResultList();
    }

    public int saveMeal(Meal meal) {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        session.saveOrUpdate(meal);
        return (int)meal.getMealId();
    }

    public void deleteMeal(int theId) {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        Meal meal = (Meal)session.get(Meal.class, (long)theId);
        session.delete(meal);
    }

    public Meal getMeal(int theId) {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        return (Meal)session.get(Meal.class, (long)theId);
    }

    public void saveCategory(Category category) {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        session.saveOrUpdate(category);
    }

    public void deleteCategory(int id) {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        Category category = (Category)session.get(Category.class, (long)id);
        session.delete(category);
    }

    public Category getCategory(int id) {
        Session session = (Session)this.entityManager.unwrap(Session.class);
        return (Category)session.get(Category.class, (long)id);
    }
}
