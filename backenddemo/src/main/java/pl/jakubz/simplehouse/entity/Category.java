package pl.jakubz.simplehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "category")
    @Size(min = 3, max = 45, message = "has to be between 3-45 chars")
    @NotBlank(message = "is required")
    private String category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Meal> meals = new ArrayList<>();

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }

   /* public void add(Meal meal)
    {
        if(meals == null)
        {
            meals = new ArrayList<>();
        }

        meals.add(meal);
        meal.setCategory(this);
    }*/
}
