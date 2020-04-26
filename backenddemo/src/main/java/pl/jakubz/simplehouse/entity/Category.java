
package pl.jakubz.simplehouse.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Column(name = "category")
    @Size(
            min = 3,
            max = 45,
            message = "has to be between 3-45 chars"
    )
    @NotBlank(
            message = "is required"
    )
    private String category;
    @OneToMany(
            cascade = {CascadeType.ALL},
            mappedBy = "category"
    )
    private List<Meal> meals = new ArrayList();

    public Category(final long id, final String category, final List<Meal> meals) {
        this.id = id;
        this.category = category;
        this.meals = meals;
    }

    public Category() {
    }

    public String toString() {
        return "Category{id=" + this.id + ", category='" + this.category + '\'' + '}';
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public List<Meal> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<Meal> meals) {
        this.meals = meals;
    }
}
