package com.example.saleCampaign.Model;


<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
=======
>>>>>>> 76a03b7672949f5d75ac108297a83e9a5269b12e
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "price_history")
public class PriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
<<<<<<< HEAD
    @JsonBackReference
    private Product product;

    public PriceHistory(Product product, double price, double finalPrice, double discountInPercentage, double discountAmount, LocalDate localDate) {
        this.product = product;
        this.price = price;
        FinalPrice = finalPrice;
        this.discountInPercentage = discountInPercentage;
        this.discountAmount = discountAmount;
=======
    private Product product;

    public PriceHistory(Product product, double price, double discountPrice, LocalDate localDate) {
        this.product = product;
        this.price = price;
        this.discountPrice = discountPrice;
>>>>>>> 76a03b7672949f5d75ac108297a83e9a5269b12e
        this.localDate = localDate;
    }

    public PriceHistory(){}

    @Column(name = "price")
    private double price;

<<<<<<< HEAD
    @Column(name = "final_price")
    private double FinalPrice;

    @Column(name = "discount%")
    private double discountInPercentage;

    @Column(name = "discount_amount")
    private double discountAmount;


    public double getFinalPrice() {
        return FinalPrice;
    }


=======
    @Column(name = "discount_price")
    private double discountPrice;
>>>>>>> 76a03b7672949f5d75ac108297a83e9a5269b12e

    @Column(name = "date")
    private LocalDate localDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

<<<<<<< HEAD
    public void setFinalPrice(double finalPrice) {
        FinalPrice = finalPrice;
    }

    public double getDiscountInPercentage() {
        return discountInPercentage;
    }

    public void setDiscountInPercentage(double discountInPercentage) {
        this.discountInPercentage = discountInPercentage;
    }

    @Override
    public String toString() {
        return "PriceHistory{" +
                "discountAmount=" + discountAmount +
                ", id=" + id +
                ", product=" + product +
                ", price=" + price +
                ", FinalPrice=" + FinalPrice +
                ", discountInPercentage=" + discountInPercentage +
                ", localDate=" + localDate +
                '}';
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
=======
    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }


>>>>>>> 76a03b7672949f5d75ac108297a83e9a5269b12e
}
