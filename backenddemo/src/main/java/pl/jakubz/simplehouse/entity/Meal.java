package pl.jakubz.simplehouse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import org.apache.tomcat.util.codec.binary.Base64;

@Entity
@Table(
        name = "meals"
)
public class Meal {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private long mealId;
    @Column(
            name = "name"
    )
    @NotBlank(
            message = "is required"
    )
    @Size(
            min = 3,
            max = 80,
            message = "needs to be at between 3-80 chars"
    )
    private String mealName;
    @Column(
            name = "description"
    )
    @NotBlank(
            message = "is required"
    )
    private String mealDesc;
    @Column(
            name = "price"
    )
    @PositiveOrZero(
            message = "has to be greater or equal to 0"
    )
    @NotNull(
            message = "is required"
    )
    private float mealPrice;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "category_id"
    )
    @NotNull(
            message = "is required, if there are no categories <a href='${pageContext.request.contextPath}/categoryForm'>create</a> one"
    )
    private Category category;
    @Column(
            name = "img"
    )
    private byte[] img;
    private transient String encoded64;

    public Meal(final long mealId, final String mealName, final String mealDesc, final float mealPrice, final Category category, final byte[] img, final String encoded64) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealDesc = mealDesc;
        this.mealPrice = mealPrice;
        this.category = category;
        this.img = img;
        this.encoded64 = encoded64;
    }

    public Meal() {
    }

    public String toString() {
        return "Meal{mealId=" + this.mealId + ", mealName='" + this.mealName + '\'' + ", mealDesc='" + this.mealDesc + '\'' + ", mealPrice=" + this.mealPrice + '\'' + ", category=" + this.category.getCategory() + '\'' + '}';
    }

    public long getMealId() {
        return this.mealId;
    }

    public void setMealId(final long mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return this.mealName;
    }

    public void setMealName(final String mealName) {
        this.mealName = mealName;
    }

    public String getMealDesc() {
        return this.mealDesc;
    }

    public void setMealDesc(final String mealDesc) {
        this.mealDesc = mealDesc;
    }

    public float getMealPrice() {
        return this.mealPrice;
    }

    public void setMealPrice(final float mealPrice) {
        this.mealPrice = mealPrice;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public byte[] getImg() {
        return this.img;
    }

    public void setImg(final byte[] img) {
        this.img = img;
    }

    public String getEncoded64() {
        return this.encoded64;
    }

    public void setEncoded64(byte[] bytesArray) {
        this.encoded64 = Base64.encodeBase64String(bytesArray);
    }
}