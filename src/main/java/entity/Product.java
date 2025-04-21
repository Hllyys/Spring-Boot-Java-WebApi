package entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Table(name="product")
@Entity

public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="price")
    private Float price;
    @ManyToOne
    @JoinColumn(name="category_id",nullable=false)
    private Category category;
     
    public Product() {}
    public Product(String title, Float price, Category category) {
        this.id=id;
        this.title = title;
        this.price = price;
        this.category = category;
    }
    public Integer getId() {
        return id;
    }
    public void setId(){
        this.id=id;
    }
    public String getTitle() {
        return title;
        }
    public void setTitle(String title) {
        this.title=title;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price=price;}
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category=category;
    }

}