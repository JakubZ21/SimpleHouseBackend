package pl.jakubz.simplehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meals")
public class Meal {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long mealId;
    @Column(name = "name")
    @NotBlank(message = "is required")
    @Size(min = 3, max = 80,message = "needs to be at between 3-80 chars")
    private String mealName;
    @Column(name = "description")
    @NotBlank(message = "is required")
    private String mealDesc;
    @Column(name = "price")
    @PositiveOrZero(message = "has to be greater or equal to 0")
    @NotNull(message = "is required")
    private float mealPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @NotNull(message = "is required, if there are no categories <a href='${pageContext.request.contextPath}/categoryForm'>create</a> one")
    private Category category;
    @Column(name = "img_url")
    private String imgUrl;
    @Override
    public String toString() {
        return "Meal{" +
                "mealId=" + mealId +
                ", mealName='" + mealName + '\'' +
                ", mealDesc='" + mealDesc + '\'' +
                ", mealPrice=" + mealPrice+'\''+
                ", category=" + category.getCategory()+'\''+
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
