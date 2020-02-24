package pl.jakubz.simplehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String mealName;
    @Column(name = "description")
    private String mealDesc;
    @Column(name = "price")
    private float mealPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "img_url")
    private String imgUrl;

    @Override
    public String toString() {
        return "Meal{" +
                "mealId=" + mealId +
                ", mealName='" + mealName + '\'' +
                ", mealDesc='" + mealDesc + '\'' +
                ", mealPrice=" + mealPrice+
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
